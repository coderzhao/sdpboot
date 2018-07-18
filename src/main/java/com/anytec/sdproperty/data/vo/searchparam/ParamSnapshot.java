package com.anytec.sdproperty.data.vo.searchparam;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *  人脸识别sdk请求到服务器端的数据类型
 */
public class ParamSnapshot implements Serializable {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date starttime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endtime;

    private Integer ipcId;
    private String guestCode;

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getIpcId() {
        return ipcId;
    }

    public void setIpcId(Integer ipcId) {
        this.ipcId = ipcId;
    }

    public String getGuestCode() {
        return guestCode;
    }

    public void setGuestCode(String guestCode) {
        this.guestCode = guestCode;
    }
}
