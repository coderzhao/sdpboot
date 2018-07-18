package com.anytec.sdproperty.config;
/**
 * 服务器启动时自动执行
 */


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.anytec.sdproperty.fd.CameraDataBootstrap;
import com.anytec.sdproperty.fd.FDCameraDataHandler;
import com.anytec.sdproperty.hcsdk.DeviceInfo;
import com.anytec.sdproperty.hcsdk.HCSDKHandler;
import com.sun.jna.NativeLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;


@Configuration
@Order(value = 1)
public class MyApplicationRunner implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyApplicationRunner.class);

    @Autowired
    private GeneralConfig config;
    @Autowired
    private HCSDKHandler hcsdkHandler;
    @Autowired
    private CameraDataBootstrap cameraDataBootstrap;
    @Autowired
    FDCameraDataHandler fdCameraDataHandler;


    @Override
    public void run(ApplicationArguments arg) throws Exception {
        logger.info("====== 启动时执行 =======");
        config.getCameraPort();
        fdCameraDataHandler.init();
        logger.info("启动阔展摄像头监听");
        cameraDataBootstrap.init();
        /*logger.info("初始化巨龙Camera");
        String cameraIps = config.getCameraIpList();
        String[] cameraIpList;
        if(cameraIps.contains(",")){
            cameraIpList = cameraIps.split(",");
        }else {
            cameraIpList = new String[]{cameraIps};
        }

        for (int i = 0; i < cameraIpList.length; i++) {
            String ip = cameraIpList[i];
            DeviceInfo deviceInfo = new DeviceInfo(ip,
                    config.getCameraUsername(),config.getCameraPassword(),config.getCameraPort());
            logger.info("设置接收人脸图片,ip: "+ip);
            if(hcsdkHandler.loginCamera(deviceInfo)){
                NativeLong alarmHandle = hcsdkHandler.setupAlarmChan(deviceInfo.getLoginId());
            }
        }*/
    }

}
