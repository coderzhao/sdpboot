package com.anytec.sdproperty.data.model;

import java.io.Serializable;
import java.util.Date;

public class TbIpc implements Serializable {
    private Integer id;

    private String name;

    private String address;

    private Integer doorId;

    private Date createTime;

    private String cameraId;

    private String snapTimestamp;

    private String netaddress;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getDoorId() {
        return doorId;
    }

    public void setDoorId(Integer doorId) {
        this.doorId = doorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCameraId() {
        return cameraId;
    }

    public void setCameraId(String cameraId) {
        this.cameraId = cameraId == null ? null : cameraId.trim();
    }

    public String getSnapTimestamp() {
        return snapTimestamp;
    }

    public void setSnapTimestamp(String snapTimestamp) {
        this.snapTimestamp = snapTimestamp == null ? null : snapTimestamp.trim();
    }

    public String getNetaddress() {
        return netaddress;
    }

    public void setNetaddress(String netaddress) {
        this.netaddress = netaddress == null ? null : netaddress.trim();
    }
}