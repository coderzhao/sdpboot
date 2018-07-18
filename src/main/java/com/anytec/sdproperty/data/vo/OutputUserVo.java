package com.anytec.sdproperty.data.vo;

import com.anytec.sdproperty.data.model.TbUser;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by xuxinjian on 17/7/6.
 */
public class OutputUserVo implements Serializable {
//    private static final long serialVersionUID = 1L;
    private Integer id;
    private String mobile;
    private String name;
    private Integer roleId;
    private Integer status;
    private Date createTime;
    private Date lastTime;
    private Integer doorId;

    private String doorName;

    private List<TbIpcVo> listIpcVo;

    public OutputUserVo(TbUser input){
        this.setCreateTime(input.getCreateTime());
        this.setLastTime(input.getLastTime());
        this.setDoorId(input.getDoorId());
        this.setId(input.getId());
        this.setName(input.getName());
        this.setMobile(input.getMobile());
        this.setRoleId(input.getRoleId());
        this.setStatus(input.getStatus());
    }

    public String getDoorName() {
        return doorName;
    }

    public void setDoorName(String doorName) {
        this.doorName = doorName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Integer getDoorId() {
        return doorId;
    }

    public void setDoorId(Integer doorId) {
        this.doorId = doorId;
    }

    public List<TbIpcVo> getListIpcVo() {
        return listIpcVo;
    }

    public void setListIpcVo(List<TbIpcVo> listIpcVo) {
        this.listIpcVo = listIpcVo;
    }
}
