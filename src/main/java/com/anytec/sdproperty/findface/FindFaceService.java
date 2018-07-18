package com.anytec.sdproperty.findface;



import com.anytec.sdproperty.pojo.DetectPojo;
import com.anytec.sdproperty.pojo.IdentifyPojo;
import com.anytec.sdproperty.pojo.VerifyPojo;
import com.anytec.sdproperty.pojo.sdkmodel.FaceInfo;
import org.springframework.stereotype.Service;


@Service
public interface FindFaceService {

    DetectPojo imageDetect(byte[] photo);

    VerifyPojo imagesVerify(byte[] photo1, byte[] photo2);

    IdentifyPojo imageIdentify(byte[] photo, FaceInfo face);
}
