package com.anytec.sdproperty.hcsdk;

import com.sun.jna.NativeLong;

public class DeviceInfo {
    private String deviceIp;
    private String userName;
    private String password;
    private short port;
    private NativeLong loginId;

    public DeviceInfo(String deviceIp,String userName,String password,short port){
        this.deviceIp = deviceIp;
        this.userName = userName;
        this.password = password;
        this.port = port;
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public short getPort() {
        return port;
    }

    public NativeLong getLoginId() {
        return loginId;
    }

    public void setLoginId(NativeLong loginId) {
        this.loginId = loginId;
    }

}
