package com.anytec.sdproperty.data.model;

import java.io.Serializable;
import java.util.Date;

public class TbSnapshot implements Serializable {
    private Integer id;

    private String imagefile;

    private Date createTime;

    private Integer ipcId;

    private String guestCode;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagefile() {
        return imagefile;
    }

    public void setImagefile(String imagefile) {
        this.imagefile = imagefile == null ? null : imagefile.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        this.guestCode = guestCode == null ? null : guestCode.trim();
    }
}