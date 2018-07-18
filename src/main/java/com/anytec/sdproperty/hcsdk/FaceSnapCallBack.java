package com.anytec.sdproperty.hcsdk;

import com.anytec.sdproperty.fd.FDCameraDataHandler;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FaceSnapCallBack implements HCNetSDK.FMSGCallBack {
    private static final Logger logger = LoggerFactory.getLogger(FaceSnapCallBack.class);

    @Autowired
    private FDCameraDataHandler fdCameraDataHandler;

    @Override
    public void invoke(NativeLong lCommand, HCNetSDK.NET_DVR_ALARMER pAlarmer, Pointer pAlarmInfo, int dwBufLen, Pointer pUser) {
        logger.info(" 接收人脸图片数据,lCommand: "+lCommand.intValue());
        //人脸识别结果上传
        if(lCommand.intValue() == HCNetSDK.COMM_UPLOAD_FACESNAP_RESULT){
            HCNetSDK.NET_VCA_FACESNAP_RESULT strFaceSnapInfo = new HCNetSDK.NET_VCA_FACESNAP_RESULT();
            strFaceSnapInfo.write();
            Pointer pFaceSnapInfo = strFaceSnapInfo.getPointer();
            pFaceSnapInfo.write(0, pAlarmInfo.getByteArray(0, strFaceSnapInfo.size()), 0, strFaceSnapInfo.size());
            strFaceSnapInfo.read();
            if(strFaceSnapInfo.dwFacePicLen>0) {
                byte[] facePic = strFaceSnapInfo.pBuffer1.getByteArray(0, strFaceSnapInfo.dwFacePicLen);
                byte[] ip = strFaceSnapInfo.struDevInfo.struDevIP.sIpV4;
                byte[] validIp = null;
                for(int i=11;i<ip.length;i++){
                    if(ip[i] == 0){
                        validIp = new byte[i];
                        System.arraycopy(ip,0,validIp,0,i);
                        logger.info(new String(validIp));
                        break;
                    }
                }
                if(validIp == null){
                    validIp = ip;
                }
                fdCameraDataHandler.onCameraData(facePic,new String(validIp));
            }
        }else {
            logger.warn("非人脸识别结果上传！");
        }
    }
}
