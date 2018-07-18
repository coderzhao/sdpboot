package com.anytec.sdproperty.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.anytec.sdproperty.config.GeneralConfig;
import com.anytec.sdproperty.dao.TbSnapshotFaceMapper;
import com.anytec.sdproperty.data.model.*;
import com.anytec.sdproperty.pojo.DetectPojo;
import com.anytec.sdproperty.pojo.IdentifyPojo;
import com.anytec.sdproperty.pojo.sdkmodel.FaceInfo;
import com.anytec.sdproperty.pojo.sdkmodel.IdentifyFace;
import com.anytec.sdproperty.pojo.sdkmodel.MatchFace;
import com.anytec.sdproperty.findface.FindFaceService;
import com.anytec.sdproperty.jedis.NecessaryDataService;
import com.anytec.sdproperty.service.*;
import com.anytec.sdproperty.util.ImageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service
public class BusinessServiceImpl implements BusinessService {

    private static final Logger logger = LoggerFactory.getLogger(BusinessServiceImpl.class);

    private static final ThreadLocal<SimpleDateFormat> sdfs = new ThreadLocal<>();

    @Autowired
    private FindFaceService findFaceService;
    @Autowired
    private GeneralConfig generalConfig;
    @Autowired
    private DoorLockService doorLockService;
    @Autowired
    private SettingService settingService;
    @Autowired
    private SnapshotService snapshotService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private NecessaryDataService necessaryDataService;
    @Autowired
    private TbSnapshotFaceMapper mTbSnapshotFaceMapper;

    @Override
    public void analyse(byte[] image, String mac) {

        if (image == null || mac == null)
            return;
        IdentifyPojo identifyPojo;
        if (mac.contains(":")) {
            //识别前探测分析人脸大小
            DetectPojo detectPojos = findFaceService.imageDetect(image);
            if (detectPojos == null || detectPojos.getFaces() == null || detectPojos.getFaces().size() == 0) {
                return;
            }
            FaceInfo faceInfo = detectPojos.getFaces().get(0);
            if (detectPojos.getFaces().size() > 1) {
                for (int i = 1; i < detectPojos.getFaces().size(); i++) {
                    faceInfo = faceSizeCompare(faceInfo, detectPojos.getFaces().get(i));
                }
            }
            if (calSize(faceInfo) < generalConfig.getIdentifySize())
                return;

            //识别
            identifyPojo = findFaceService.imageIdentify(image, faceInfo);
        } else {
            identifyPojo = findFaceService.imageIdentify(image, null);
        }

        if (identifyPojo == null)
            return;
        identifyPojo.getResults().keySet().forEach((key) -> {
            try {
                boolean identify = false;
                MatchFace matchFace = null;
                List<MatchFace> matchFaces = identifyPojo.getResults().get(key);
                Map<String, Object> replyInfo = new HashMap<>();
                //获取人脸图片
                String[] coordinate = key.substring(1, key.length() - 1).replace(" ", "").split(",");
                int x1 = Integer.parseInt(coordinate[0]);
                int y1 = Integer.parseInt(coordinate[1]);
                int x2 = Integer.parseInt(coordinate[2]);
                int y2 = Integer.parseInt(coordinate[3]);
                x1 = x1 < 0 ? 0 : x1;
                y1 = y1 < 0 ? 0 : y1;
                BufferedImage bufferedImage = ImageUtil.cutImg(image, "jpeg", x1, y1, x2 - x1, y2 - y1);
                byte[] faceSnap = ImageUtil.bufferedImageToBytes(bufferedImage, "jpeg");

                //判断是否为符合条件的业主
                if (null != matchFaces && matchFaces.size() > 0) {
                    String sdkId = matchFaces.get(0).getFace().getId();
                    logger.info("sdk_id: " + sdkId);
                    if (settingService.checkConfidenceEnough(matchFaces.get(0).getConfidence())) {
                        matchFace = matchFaces.get(0);
                        TbGuest guest = necessaryDataService.getTbGuest(sdkId);
                        //查询访客是否存在
                        if (guest != null) {
                            //门禁操作
                            TbIpc camera = necessaryDataService.getCamera(mac);
                            if (camera == null) {
                                logger.info("摄像头在库中显示不存在！");
                                return;
                            }
                            //查询访客身份
                            TbGuestRole role = necessaryDataService.getTbGuestRole(guest.getGuestRoleId());
                            if (role != null) {
                                identify = true;
                                replyInfo.put("roleName", sdkId);
                                replyInfo.put("photo", Base64.getEncoder().encodeToString(faceSnap));
                                replyInfo.put("securityLevel", role.getSecurityLevel());
                                simpMessagingTemplate.convertAndSend("/topic/" + mac, new JSONObject(replyInfo).toJSONString());

                                logger.info("开始进行门禁操作：" + camera.getCameraId());
                                if (role.getSecurityLevel().toString().equals(generalConfig.getDoorType())) {
                                    logger.info("危险人员：检查是否设置警报");
                                    TbDoorLock dangerLock = necessaryDataService.getTbDangerLock(camera.getDoorId());
                                    if (dangerLock != null) {
                                        logger.info("开启警报！");
                                        doorLockService.alarmDangerLock(dangerLock);
                                    } else {
                                        logger.info("未设置警报");
                                    }

                                } else if (role.getAutoOpenDoor() == 1 && !role.getSecurityLevel().toString().equals(generalConfig.getDoorType())) {
                                    logger.info("正常人员：检查是否设置开门");
                                    TbDoorLock openLock = necessaryDataService.getTbOpenLock(camera.getDoorId());
                                    if (openLock != null) {
                                        logger.info("自动开门！");
                                        doorLockService.openDoorLock(openLock, guest, role);
                                    } else {
                                        logger.info("未设置开门");
                                    }
                                }
                            }else {
                                logger.info("tb_guest_role查询不到该访客,roleId: "+guest.getGuestRoleId());
                            }
                        }else{
                            logger.info("tb_guest查询不到该访客");
                        }
                    }
                }
                if (!identify) {
                    replyInfo.put("photo", Base64.getEncoder().encodeToString(faceSnap));
                    simpMessagingTemplate.convertAndSend("/topic/" + mac, new JSONObject(replyInfo).toJSONString());
                }
                //快照数据存储
                TbIpc camera = necessaryDataService.getCamera(mac);

                //获取存储路径
                String cam_folder = mac.replaceAll(":", "");
                SimpleDateFormat sdf = sdfs.get();
                if (sdf == null) {
                    //sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
                    sdf = new SimpleDateFormat("yyyy-MM-dd");
                    sdfs.set(sdf);
                }
                String snapAndCamera = generalConfig.getDataStorage() + "/" + cam_folder;
                Date date = new Date();
                createFolder(generalConfig.getDataStorage(), cam_folder);
                createFolder(snapAndCamera, sdf.format(date));
                String fileName = System.currentTimeMillis() + ".jpg";
                Path path = Paths.get(generalConfig.getDataStorage(), cam_folder, sdf.format(date), fileName);
                //入数据库
                if (matchFace != null) {
                    int snapshotId = saveToSnapshot(camera, path.toString(), matchFace.getFace().getId());
                    saveToSnapshotFace(matchFace, snapshotId,camera.getId());
                }else {

                }
                //本地存储
                saveSnapshotToFileSystem(bufferedImage, path);

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

    }


    private void saveSnapshotToFileSystem(BufferedImage image, Path path) {
        try {
            ImageIO.write(image, "jpeg", path.toFile());
        } catch (IOException e) {
            logger.error("Failed to save snapshot image file in " + path.toString());
        }
    }


    private int saveToSnapshot(TbIpc camera, String imageFile, String guestCode) {
        TbSnapshot tbSnapshot = new TbSnapshot();
        tbSnapshot.setIpcId(camera.getId());
        tbSnapshot.setCreateTime(new Date());
        tbSnapshot.setImagefile(imageFile);
        tbSnapshot.setGuestCode(guestCode);
//        tbSnapshot.setId(1);
        snapshotService.insert(tbSnapshot);
        return tbSnapshot.getId();
    }


    private int saveToSnapshotFace(MatchFace matchFace, int snapShotId, int ipc_id) {
        TbSnapshotFace tbSnapshotFace = new TbSnapshotFace();
        IdentifyFace identifyFace = matchFace.getFace();
        if (identifyFace.getAge() != null) {
            tbSnapshotFace.setAge((int) Math.ceil(identifyFace.getAge()));
        }
        if (identifyFace.getGender() != null) {
            tbSnapshotFace.setGender(identifyFace.getGender());
        }
        tbSnapshotFace.setConfidence((float) matchFace.getConfidence());
        tbSnapshotFace.setGuestCode(identifyFace.getId());
        tbSnapshotFace.setThumbnail(identifyFace.getThumbnail());
        tbSnapshotFace.setNormalized(identifyFace.getNormalized());
        tbSnapshotFace.setSnapshotId(snapShotId);
        tbSnapshotFace.setIpcId(ipc_id);
        tbSnapshotFace.setMeta(identifyFace.getMeta());
        LocalDateTime localDateTime = LocalDateTime.parse(identifyFace.getTimestamp());
        long timestamp = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        tbSnapshotFace.setTimestamp(new Date(timestamp));
        return mTbSnapshotFaceMapper.insert(tbSnapshotFace);
    }

    private FaceInfo faceSizeCompare(FaceInfo faceDefine1, FaceInfo faceDefine2) {
        double size1 = calSize(faceDefine1);
        double size2 = calSize(faceDefine2);
        if (size1 > size2) {
            return faceDefine1;
        } else {
            return faceDefine2;
        }
    }

    private double calSize(FaceInfo faceDefine) {
        return faceDefine.getX2() - faceDefine.getX1();
    }

    private void createFolder(String base, String cameraName) {
        Path path = Paths.get(base, cameraName);
        if (!path.toFile().exists())
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                logger.error("Failed to create diectory " + path.toString());
                e.printStackTrace();
            }
    }

}
