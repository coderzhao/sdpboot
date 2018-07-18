package com.anytec.sdproperty.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GeneralConfig {

    //FindFace SDK
    @Value("${sdk.host_ip}")
    private String sdkIp;

    @Value("${sdk.port}")
    private short sdkPort;

    @Value("${sdk.token}")
    private String token;

    @Value("${sdk.version}")
    private String sdkVersion;

    //图片流控制
    @Value("${data.threshold}")
    private int dataThreshold;

    @Value("${data.thread_num}")
    private int dataThreadNum;

    @Value("${data.draw}")
    private int dataDraw;

    //识别控制
    @Value("${identify.type}")
    private String identifyType;

    @Value("${identify.size}")
    private int identifySize;

    //本地存储路径
    @Value("${data.storage}")
    private String dataStorage;

    @Value("${door.switch_address}")
    private String switchAddress;

    @Value("${door.type}")
    private String doorType;
    @Value("${door.dangerLevel}")
    private String dangerLevel;

    //巨龙Camera
    @Value("${jvtcamera.ip}")
    private String cameraIpList;
    @Value("${jvtcamera.port}")
    private short cameraPort;
    @Value("${jvtcamera.username}")
    private String cameraUsername;
    @Value("${jvtcamera.password}")
    private String cameraPassword;

    //阔展摄像头分辨率
    @Value("${kzcamera.resolution.width}")
    private int cameraWidth;
    @Value("${kzcamera.resolution.height}")
    private int cameraHeight;

    //基本设置
    @Value("${sysconfig.upload_path}")
    private String upload_path;
    @Value("${sysconfig.snapshot_path}")
    private String snapshot_path;


    public String getDataStorage() {
        return dataStorage;
    }

    public String getSdkIp() {
        return sdkIp;
    }

    public short getSdkPort() {
        return sdkPort;
    }

    public String getToken() {
        return token;
    }

    public String getSdkVersion() {
        return sdkVersion;
    }

    public int getDataThreshold() {
        return dataThreshold;
    }

    public int getDataThreadNum() {
        return dataThreadNum;
    }


    public String getIdentifyType() {
        return identifyType;
    }

    public int getIdentifySize() {
        return identifySize;
    }

    public String getSwitchAddress() {
        return switchAddress;
    }

    public String getDoorType() {
        return doorType;
    }

    public String getDangerLevel() { return dangerLevel; }

    public String getCameraIpList() {
        return cameraIpList;
    }

    public short getCameraPort() {
       return cameraPort;
    }

    public String getCameraUsername() {
        return cameraUsername;
    }

    public String getCameraPassword() {
        return cameraPassword;
    }

    public int getDataDraw() {
        return dataDraw;
    }

    public int getCameraWidth() {
        return cameraWidth;
    }

    public int getCameraHeight() {
        return cameraHeight;
    }

    public String getUpload_path() {
        return upload_path;
    }

    public String getSnapshot_path() {
        return snapshot_path;
    }
}
