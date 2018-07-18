package com.anytec.sdproperty.fd;

import com.anytec.sdproperty.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;

public class FDThread implements Runnable {

    private byte[] image;
    private String mac;

    private BusinessService businessService;

    FDThread(byte[] image,String mac,BusinessService businessService){
        this.image=image;
        this.mac=mac;
        this.businessService=businessService;
    }

    @Override
    public void run() {
        businessService.analyse(image,mac);
    }
}
