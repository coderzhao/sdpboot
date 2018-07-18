package com.anytec.sdproperty.hcsdk;

import com.anytec.sdproperty.config.GeneralConfig;
import com.sun.jna.NativeLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class HCSDKHandler {

    private static final Logger logger = LoggerFactory.getLogger(HCSDKHandler.class);

    static HCNetSDK hCNetSDK = HCNetSDK.INSTANCE;
    DeviceInfo deviceInfo; //设备信息
    NativeLong loginId; //登录后获取的Id
    NativeLong alarmHandle; //报警布防句柄
    MyExceptionCallBack myExceptionCallBack; //异常信息回调函数

    @Autowired
    GeneralConfig config;
    @Autowired
    private FaceSnapCallBack faceSnapCallBack;//报警布防回调函数


    @PostConstruct
    public void init() {
        if (hCNetSDK.NET_DVR_Init()) {
            logger.info("=====初始化HCNETSDK成功=====");
        } else {
            logger.error("Error：初始化HCNETSDK失败");
        }
        hCNetSDK.NET_DVR_SetConnectTime(2000, 1);
        hCNetSDK.NET_DVR_SetReconnect(10000, true);
        hCNetSDK.NET_DVR_SetLogToFile(true, null, false);
        myExceptionCallBack = new MyExceptionCallBack();
        hCNetSDK.NET_DVR_SetExceptionCallBack_V30(0, 0, myExceptionCallBack, null);
    }


    public boolean loginCamera(DeviceInfo deviceInfo) {
        HCNetSDK.NET_DVR_USER_LOGIN_INFO struLoginInfo = new HCNetSDK.NET_DVR_USER_LOGIN_INFO();
        HCNetSDK.NET_DVR_DEVICEINFO_V40 struDeviceInfo = new HCNetSDK.NET_DVR_DEVICEINFO_V40();
        for (int i = 0; i < deviceInfo.getDeviceIp().length(); i++) {
            struLoginInfo.sDeviceAddress[i] = (byte) deviceInfo.getDeviceIp().charAt(i);
        }
        for (int i = 0; i < deviceInfo.getUserName().length(); i++) {
            struLoginInfo.sUserName[i] = (byte) deviceInfo.getUserName().charAt(i);
        }
        for (int i = 0; i < deviceInfo.getPassword().length(); i++) {
            struLoginInfo.sPassword[i] = (byte) deviceInfo.getPassword().charAt(i);
        }
        struLoginInfo.wPort = deviceInfo.getPort();
        struLoginInfo.bUseAsynLogin = 0;
        struLoginInfo.write();
        NativeLong loginId = hCNetSDK.NET_DVR_Login_V40(struLoginInfo.getPointer(), struDeviceInfo.getPointer());
        if (loginId.longValue() >= 0 && hCNetSDK.NET_DVR_GetLastError() == 0) {
            logger.info(deviceInfo.getDeviceIp() + " 注册设备成功");
            logger.info("loginId: "+loginId);
            this.loginId = loginId;
            deviceInfo.setLoginId(loginId);
            return true;
        } else {
            logger.error(deviceInfo.getDeviceIp() + " 注册失败，错误码：" + hCNetSDK.NET_DVR_GetLastError());
            return false;
        }
    }

    public boolean loginoutCamera() {
        logger.info("logout loginId: "+loginId);
        if (!hCNetSDK.NET_DVR_Logout(loginId)) {
            logger.error(loginId + " 注销设备失败，错误码：" + hCNetSDK.NET_DVR_GetLastError());
            return false;
        }else {
            logger.error(loginId + " 注销设备成功！");
            return true;
        }
    }

    public NativeLong preView(DeviceInfo deviceInfo, HCNetSDK.FRealDataCallBack_V30 callBack_v30) {
        NativeLong lRealPlayHandle = null;
        HCNetSDK.NET_DVR_PREVIEWINFO strPreviewInfo = new HCNetSDK.NET_DVR_PREVIEWINFO();
        strPreviewInfo.lChannel = new NativeLong(1);//预览通道号
        strPreviewInfo.hPlayWnd = null;//需要SDK解码时句柄设为有效值，仅取流不解码时可设为空
        strPreviewInfo.dwStreamType = 1;//0-主码流，1-子码流，2-码流3，3-码流4，以此类推
        strPreviewInfo.dwLinkMode = 0;//0- TCP方式，1- UDP方式，2- 多播方式，3- RTP方式，4-RTP/RTSP，5-RSTP/HTTP
        logger.info(deviceInfo.getLoginId() + "ID");
        lRealPlayHandle = hCNetSDK.NET_DVR_RealPlay_V40(deviceInfo.getLoginId(), strPreviewInfo, callBack_v30, null);
        if (!(lRealPlayHandle.longValue() >= 0 && hCNetSDK.NET_DVR_GetLastError() == 0)) {
            logger.error("预览失败,错误码：" + hCNetSDK.NET_DVR_GetLastError());
            return null;
        }
        return lRealPlayHandle;
    }

    public void stopPreView(NativeLong lReadPlayHandle) {
        if (!hCNetSDK.NET_DVR_StopRealPlay(lReadPlayHandle)) {
            logger.error("stop preview failed");
        }
    }


    //开启布防
    public NativeLong setupAlarmChan(NativeLong loginId){

        if (hCNetSDK.NET_DVR_SetDVRMessageCallBack_V30(faceSnapCallBack, null)) {
            logger.info("=====设置报警回调函数成功=====");
        } else {
            logger.info("=====设置报警回调函数失败=====");
        }
        HCNetSDK.NET_DVR_SETUPALARM_PARAM m_strAlarmInfo = new HCNetSDK.NET_DVR_SETUPALARM_PARAM();
        m_strAlarmInfo.dwSize=m_strAlarmInfo.size();
        m_strAlarmInfo.byLevel=1;
        m_strAlarmInfo.byAlarmInfoType=1;
        m_strAlarmInfo.write();
        alarmHandle = hCNetSDK.NET_DVR_SetupAlarmChan_V41(loginId, m_strAlarmInfo);
        if(alarmHandle.intValue() == -1){
            logger.warn("布防失败");
        }else {
            logger.info("布防成功");
        }
        return alarmHandle;
    }

    //撤销布防
    public void closeAlarmChan() {
        if(hCNetSDK.NET_DVR_CloseAlarmChan_V30(alarmHandle)){
            logger.info("撤防成功");
        }else {
            logger.warn("撤防失败");
        }
    }

//    @PreDestroy
    public void cleanUp() {
        closeAlarmChan();
        loginoutCamera();
        logger.info("hcSDK cleanup");
        hCNetSDK.NET_DVR_Cleanup();
    }
}
