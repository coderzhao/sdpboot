package com.anytec.sdproperty.data.model;

import java.io.Serializable;
import java.util.Date;

public class TbGuestRole implements Serializable {
    private Integer id;

    private String name;

    private Integer securityLevel;

    private Byte autoOpenDoor;

    private Date createTime;

    private Boolean limitTime;

    private Integer openTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(Integer securityLevel) {
        this.securityLevel = securityLevel;
    }

    public Byte getAutoOpenDoor() {
        return autoOpenDoor;
    }

    public void setAutoOpenDoor(Byte autoOpenDoor) {
        this.autoOpenDoor = autoOpenDoor;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(Boolean limitTime) {
        this.limitTime = limitTime;
    }

    public Integer getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Integer openTime) {
        this.openTime = openTime;
    }
}