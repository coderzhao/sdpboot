package com.anytec.sdproperty.pojo;

import com.anytec.sdproperty.pojo.sdkmodel.FaceInfo;

import java.util.List;

public class VerifyPojo {

    private List<VerifyDuo> results;

    public List<VerifyDuo> getResults() {
        return results;
    }

    public class VerifyDuo{
        private FaceInfo bbox1;
        private FaceInfo bbox2;
        private double confidence;
        private boolean verified;

        public FaceInfo getBbox1() {
            return bbox1;
        }

        public FaceInfo getBbox2() {
            return bbox2;
        }

        public double getConfidence() {
            return confidence;
        }

        public boolean isVerified() {
            return verified;
        }
    }
}
