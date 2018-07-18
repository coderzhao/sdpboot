package com.anytec.sdproperty.data.vo;

import com.anytec.sdproperty.data.model.TbDoorLock;

/**
 * Created by xuxinjian on 17/7/6.
 */
public class TbDoorLockVo extends TbDoorLock {

    private static final long serialVersionUID = 1L;
    private String doorName;

    public TbDoorLockVo(TbDoorLock input){
        this.setCreateTime(input.getCreateTime());
        this.setIp(input.getIp());
        this.setDoorId(input.getDoorId());
        this.setId(input.getId());
        this.setSecurityLevel(input.getSecurityLevel());
        this.setName(input.getName());
        this.setPort(input.getPort());
        this.setLine(input.getLine());
        this.setTime(input.getTime());
    }

    public String getDoorName() {
        return doorName;
    }

    public void setDoorName(String doorName) {
        this.doorName = doorName;
    }
}
