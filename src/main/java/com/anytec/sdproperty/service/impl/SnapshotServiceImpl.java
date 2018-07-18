package com.anytec.sdproperty.service.impl;


import com.anytec.sdproperty.config.GeneralConfig;
import com.anytec.sdproperty.dao.*;
import com.anytec.sdproperty.data.model.*;
import com.anytec.sdproperty.data.vo.InputSnapshotVo;
import com.anytec.sdproperty.data.vo.OutputSnapshotFaceVo;
import com.anytec.sdproperty.data.vo.OutputSnapshotVo;
import com.anytec.sdproperty.data.vo.searchparam.ParamSnapshot;
import com.anytec.sdproperty.service.*;
import com.anytec.sdproperty.util.HTextUtils;
import com.anytec.sdproperty.util.NUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("SnapshotService")
public class SnapshotServiceImpl implements SnapshotService {
    private static final Logger logger = LoggerFactory.getLogger(SnapshotServiceImpl.class);
    @Autowired
    private TbSnapshotMapper mTbSnapshotMapper;
    @Autowired
    private TbSnapshotFaceMapper mTbSnapshotFaceMapper;
    @Autowired
    private TbGuestMapper mTbGuestMapper;
    @Autowired
    private TbIpcMapper mIpcMapper;
    @Autowired
    private SnapshotFaceService mSnapshotFaceService;
    @Autowired
    private GuestRoleService mGuestRoleService;
    @Autowired
    private IpcService mIpcService;
    @Autowired
    private SettingService mSettingService;
    //    @Autowired
//    private SDKService mSDKService;
    @Autowired
    private DoorLockService mDoorLockService;
    @Autowired
    private GuestService mGuestService;
    @Autowired
    private TbGuestRoleMapper mTbGuestRoleMapper;
    @Autowired
    private TbSnapshotMapper tbSnapshotMapper;
    @Autowired
    private GeneralConfig config;


    @Override
    public TbSnapshot getById(Integer id) throws HException {
        return mTbSnapshotMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(TbSnapshot snapshot) {
        tbSnapshotMapper.insert(snapshot);
        return snapshot.getId();
    }


    public List<OutputSnapshotVo> getListPage(ParamSnapshot param, int pageNum, int count, String order, String orderRule) {
        List<OutputSnapshotVo> listVo = new ArrayList<OutputSnapshotVo>();

        TbSnapshotExample example = createSnapshotExample(param);

        if (order == null || orderRule == null){
            example.setOrderByClause("id desc");
        } else{
            example.setOrderByClause(order + " " + orderRule);
        }

        //转化为vo
        PageHelper.startPage(pageNum,count);
        Page<TbSnapshot> listData = mTbSnapshotMapper.selectByExample(example);
        List<TbIpc> listIpc = mIpcService.getAllIpc();
        if (listData != null) {
            for (TbSnapshot item : listData) {
                OutputSnapshotVo vo = getVoByTbSnapshot(item);
                for (TbIpc ipcItem : listIpc) {
                    if (ipcItem.getId() == vo.getIpcId()) {
                        vo.setIpcName(ipcItem.getName());
                        break;
                    }
                }
                listVo.add(vo);
            }
        }

        return listVo;
    }

    public void delete(Integer id) {
        mTbSnapshotMapper.deleteByPrimaryKey(id);
    }

    public Map<String, Object> add(InputSnapshotVo input) {
        Map<String, Object> resultMap = null;

//        Date startDate = new Date();
//        long cost;
//        String strCost = "";

        //第一步， 根据camera_id 获取ipc_id
        TbIpcExample ipcExample = new TbIpcExample();
        TbIpcExample.Criteria ipcc = ipcExample.createCriteria();
        ipcc.andCameraIdEqualTo(input.getCamera_id());
        List<TbIpc> listIpc = mIpcMapper.selectByExample(ipcExample);
        if (listIpc == null || listIpc.size() <= 0) {
            logger.error("摄像头不存在，camera_id = " + input.getCamera_id());
            try {
                throw new Exception("摄像头不存在，camera_id = " + input.getCamera_id());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int ipcId = listIpc.get(0).getId();
//        logger.info("ipcId" + ipcId);
//        int doorId = listIpc.get(0).getDoorId();
//        logger.info("doorId" + doorId);
//        cost = new Date().getTime() - startDate.getTime();
//        strCost += "cost1:" + cost;

        //先增加快照
        TbSnapshot snapshot = new TbSnapshot();
        snapshot.setCreateTime(new Date());
        snapshot.setImagefile(input.getSnapshot_photo());
        snapshot.setIpcId(ipcId);
        //判断相似度，如果相似度低于系统设置的相似度， 则将此次识别结果取消。
//        if (null != input.getGusetCode()) {
//            snapshot.setGuestCode(input.getGusetCode() + "");
//        }
        if (input.getFace() != null) {
            TbGuest guest = mGuestService.getByCode(input.getGusetCode() + "");
            logger.info(Thread.currentThread().getName() + " sdkcode:"+input.getGusetCode());
            if (guest != null) {
                logger.info(Thread.currentThread().getName()+"sdpcode:"+ guest.getCode());
                float nowConfidence = input.getFace().getConfidence();
                if (mSettingService.checkConfidenceEnough(nowConfidence)) {
                    //如果识别出来的信任度足够
                    snapshot.setGuestCode(input.getFace().getPerson_id() + "");
//					TbGuest tbGuest =mGuestService.getByCode(input.getFace().getPerson_id() + "");
//					if(tbGuest != null){
//						Integer count =tbGuest.getCount();
//						logger.info("before count:"+count);
//						count =count+1;
//						tbGuest.setCount(count);
//						int result =mTbGuestMapper.updateByPrimaryKeySelective(tbGuest);
//					}
                }
            }

        }
        try {
            snapshot.setId(1);
            mTbSnapshotMapper.insert(snapshot);
//
//            cost = new Date().getTime() - startDate.getTime();
//            strCost += "cost2:" + cost;

            //如果识别失败， 不走一下步骤，如增加face，增加访客， 开门
            logger.info("快照已经存储，判断是否业主");
//        logger.info("mSettingService.checkConfidenceEnough(input.getFace().getConfidence())"+mSettingService.checkConfidenceEnough(input.getFace().getConfidence()));
            logger.info("访客id是否使空" + HTextUtils.isEmpty(snapshot.getGuestCode()));
            if (null != input.getFace()) {
                if (!HTextUtils.isEmpty(snapshot.getGuestCode())) {
                    //如果识别出来用户头像的code， 再增加 tb_snapshot_face 表
                    logger.info("识别出是业主---" + Thread.currentThread().getName());
                    TbSnapshotFace item = input.getFace().createSnapshot();
                    item.setSnapshotId(snapshot.getId());
                    item.setIpcId(ipcId);
                    item.setGuestCode(snapshot.getGuestCode());
//                    logger.error(input.getCamera_id());
//                    logger.error(input.getSnapshot_photo());
                    mTbSnapshotFaceMapper.insert(item);

//                    cost = new Date().getTime() - startDate.getTime();
//                    strCost += "cost3:" + cost;
                    //增加到访客列表
                    //仅当识别的code不为空， 也就是识别出结果来， 才增加到访客列表，否则不增加到访客列表
                    add2Guest(input);

//                    cost = new Date().getTime() - startDate.getTime();
//                    strCost += "cost4:" + cost;
//
//
//                    cost = new Date().getTime() - startDate.getTime();
//                    strCost += "cost8:" + cost;
//                    if (cost > 500) {
//                        logger.warn("addSendSnapshot:" + strCost);
//                    }
                } else {
                    //判断code＝ null， end
                    logger.info("code = null,陌生访客");
                }
            }
        } catch (Exception e) {
            logger.error("check error:" + e.getMessage());
        }
//        logger.info("addSendSnapshot:" + strCost);
        return resultMap;
    }

    //    private void openDoor(int doorId, InputSnapshotVo input ) {
    public void openDoorCheck(int doorId, String person_id, float confidence) {
        //是否开门
        TbDoorLock lock = mDoorLockService.getByDoorId(doorId,false);
        if (lock != null) {
            //该门岗装了门禁
//            Integer code = person_id;
            TbGuest guest = mGuestService.getByCode(person_id);
//            float nowConfidence = confidence.getFace().getConfidence();
            if (guest != null && mSettingService.checkConfidenceEnough(confidence)) {
                logger.info("check user code id:" + guest.getCode());
                TbGuestRole role = mTbGuestRoleMapper.selectByPrimaryKey(guest.getGuestRoleId());
                if (role != null) {
                    if (role.getSecurityLevel().equals(config.getDangerLevel())) {
                        TbDoorLock dangerLock = mDoorLockService.getByDoorId(doorId,true);
                        if(dangerLock!=null){
                            logger.info("识别危险人员，开启警示器");
                            logger.info("ip:" + dangerLock.getIp().toString());
                            logger.info("Port:" + dangerLock.getPort().toString());
                            logger.info("line:" + dangerLock.getLine().toString());
//                                logger.info("on_off:"+"1");
                            logger.info("time:" + dangerLock.getTime().toString());
//					String url = "http://192.168.10.208:8888/";
                            try {
                                Request.Post(config.getSwitchAddress())
                                        .connectTimeout(10000)
                                        .socketTimeout(30000)
                                        //							.addHeader("Authorization", "Token " + ntechToken)
                                        .body(MultipartEntityBuilder
                                                .create()
                                                .addTextBody("ip", dangerLock.getIp())
                                                .addTextBody("port", dangerLock.getPort().toString())
                                                .addTextBody("line", dangerLock.getLine().toString())
                                                .addTextBody("on_off", "1")
                                                .addTextBody("time", dangerLock.getTime().toString())
                                                .build())
                                        .execute().returnResponse();
                            } catch (Exception e) {
                                logger.error("开始请求异常：" + e.getMessage());
                            }
                            logger.info("警示器已开启");
                        }else {
                            logger.info("doorId:"+doorId+"未配置警示器doorlock");
                        }
                    } else if (role.getAutoOpenDoor() == 1 && !role.getSecurityLevel().equals(config.getDangerLevel())) {
                        boolean needOpen = true;
                        if (role.getLimitTime() != null) {//不为null
                            if (role.getLimitTime()) {//不为false，则进入限制时间模式
                                //如果限制开门时间
                                Date now = new Date();
                                if (guest.getLockStartTime() != null) {
                                    if (now.getTime() < guest.getLockStartTime().getTime()) {
                                        logger.info("failopendoor当前时间小于允许开门的最小时间，不开门");
                                        needOpen = false;//当前时间小于允许开门的最小时间，不开门
                                    }
                                }
                                if (guest.getLockEndTime() != null) {
                                    if (now.getTime() > guest.getLockEndTime().getTime()) {
                                        //当前时间大于允许开门的最大时间， 不开门
                                        logger.info("failopendoor当前时间大于允许开门的最大时间， 不开门");
                                        needOpen = false;
                                    }
                                }
                            }
                        }
                        if (needOpen) {
                            logger.info("识别业主，准备开锁");
                            logger.info("ip:" + lock.getIp().toString());
                            logger.info("Port:" + lock.getPort().toString());
                            logger.info("line:" + lock.getLine().toString());
//                                logger.info("on_off:"+"1");
                            logger.info("time:" + lock.getTime().toString());
//					String url = "http://192.168.10.208:8888/";
                            try {
                                Request.Post(config.getSwitchAddress())
                                        .connectTimeout(10000)
                                        .socketTimeout(30000)
                                        //							.addHeader("Authorization", "Token " + ntechToken)
                                        .body(MultipartEntityBuilder
                                                .create()
                                                .addTextBody("ip", lock.getIp())
                                                .addTextBody("port", lock.getPort().toString())
                                                .addTextBody("line", lock.getLine().toString())
                                                .addTextBody("on_off", "1")
                                                .addTextBody("time", lock.getTime().toString())
                                                .build())
                                        .execute().returnResponse();
                            } catch (Exception e) {
                                logger.error("开始请求异常：" + e.getMessage());
                            }
                            logger.info("完成开锁");
                        }
//                            logger.info("lockresult:" + resultMap.toString());
                    } else {
                        logger.info("该用户不再允许开门的时间段内，不开门");
                    }
                }
            }
        }else {
            logger.info("doorId:"+doorId+"未配置开门doorlock");
        }
    }

    public int getCount(ParamSnapshot param) {
        TbSnapshotExample example = createSnapshotExample(param);
        return (int) (mTbSnapshotMapper.countByExample(example));
    }

    public void updateSnapshot(Integer snapshotId, String guest_code) {
        TbSnapshot snapshot = mTbSnapshotMapper.selectByPrimaryKey(snapshotId);
        snapshot.setGuestCode(guest_code);
        mTbSnapshotMapper.updateByPrimaryKey(snapshot);
    }

    private TbSnapshotExample createSnapshotExample(ParamSnapshot param) {
        TbSnapshotExample example = new TbSnapshotExample();
        if (param != null) {
            TbSnapshotExample.Criteria c = example.createCriteria();

            if (param != null && param.getStarttime() != null) {
//				param.setStarttime(new Date());//test
                c.andCreateTimeGreaterThanOrEqualTo(param.getStarttime());
            }
            if (param != null && param.getEndtime() != null) {
                c.andCreateTimeLessThanOrEqualTo(param.getEndtime());
            }
            if (param.getIpcId() != null) {
                c.andIpcIdEqualTo(param.getIpcId());
            }

            if (!HTextUtils.isEmpty(param.getGuestCode())) {
                c.andGuestCodeEqualTo(param.getGuestCode());
            }

        }
        return example;
    }


    private List<TbSnapshotFace> getFacesBySnapshotId(Integer snapshotId) {
        TbSnapshotFaceExample example = new TbSnapshotFaceExample();
        TbSnapshotFaceExample.Criteria c = example.createCriteria();
        c.andSnapshotIdEqualTo(snapshotId);
        List<TbSnapshotFace> listData = mTbSnapshotFaceMapper.selectByExample(example);
        return listData;
    }

    //通过snapshot获取相关信息
    private OutputSnapshotVo getVoByTbSnapshot(TbSnapshot input) {
        OutputSnapshotVo vo = new OutputSnapshotVo();
        vo.setSnapshot(input);

        //设置snapshot对象中有的属性
        vo.setSnapshotId(input.getId());
        vo.setCreateTime(NUtil.date2String(input.getCreateTime()));
        vo.setIpcId(input.getIpcId());
        try {
            OutputSnapshotFaceVo faceVo = mSnapshotFaceService.queryOutputSnapshotFaceVoBySnapshotId(input.getId());
            if (faceVo != null) {
                vo.setAge(faceVo.getFace().getAge());
                vo.setPhoto(faceVo.getFace().getPhoto());
                vo.setName(faceVo.getName());
                vo.setGuestCode(faceVo.getGuest().getCode());
                vo.setConfidence(faceVo.getFace().getConfidence());
                //讲访客信息中的源图，拼接城url返回
                String imageUrl = mSettingService.getPhotoByImageFile(faceVo.getGuest().getImage());
                vo.setOrginPhoto(faceVo.getGuest().getImage());

                vo.setRoleName("未知");
//                vo.setSecurityLevel(NConst.SECURITY_UNKNOW);

                Integer roleId = faceVo.getRoleId();
                if (roleId != null) {
                    TbGuestRole role = mGuestRoleService.getById(roleId);
                    if (role != null) {
                        vo.setRoleName(role.getName());
                        vo.setSecurityLevel(role.getSecurityLevel());
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
//		//此处将imagefile临时作为photo返回 －test
//		String imageFile = input.getImagefile();
//		int index = imageFile.indexOf("/images/");
//		String subStr = imageFile.substring(index);
//		String strPhoto = "http://1747785do9.imwork.net:8889" + subStr;
//		vo.setPhoto(strPhoto);
        vo.setPhoto(mSettingService.getPhotoByImageFile(input.getImagefile()));

        return vo;

    }

    private void add2Guest(InputSnapshotVo input) {
        try {
            String code = input.getFace().getPerson_id() + "";
            TbGuestExample example = new TbGuestExample();
            TbGuestExample.Criteria c = example.createCriteria();
            c.andCodeEqualTo(code);
            List<TbGuest> list = mTbGuestMapper.selectByExample(example);
            if (list != null && list.size() > 0) {
                //访客之前访问过
                TbGuest guest = list.get(0);
                double age = input.getFace().getAge();
                guest.setAge((int) age);
                guest.setLastTime(new Date());
                if (input.getFace().getGender().equalsIgnoreCase("male")) {
                    guest.setGender(1);
                } else {
                    guest.setGender(0);
                }
                Integer count = guest.getCount();
                if (count == null) {
                    count = 0;
                }
                guest.setCount(count + 1);
                //访客图片不更新， 所以注释掉
//				if(HTextUtils.isEmpty(guest.getImage())) {
//					guest.setImage(input.getSnapshot_photo());
//				}
                mTbGuestMapper.updateByPrimaryKey(guest);
            }
//			else{
//				//访客之前没访问过
//				TbGuest guest = new TbGuest();
//				guest.setCode(code);
//				double age = input.getFace().getAge();
//				guest.setAge((int)age);
//				guest.setFirstTime(new Date());
//				guest.setLastTime(new Date());
//				if(input.getFace().getGender().equalsIgnoreCase("male")){
//					guest.setGender(1);
//				}else{
//					guest.setGender(0);
//				}
//				guest.setCount(1);
//				guest.setImage(input.getSnapshot_photo());
//				mTbGuestMapper.insert(guest);
//			}

        } catch (Exception e) {

        }
    }
}