package com.anytec.sdproperty.data.vo;

import com.anytec.sdproperty.data.model.TbIpc;

/**
 * Created by xuxinjian on 17/7/6.
 */
public class TbIpcVo extends TbIpc {

    private static final long serialVersionUID = 1L;
    private String doorName;

    public TbIpcVo(TbIpc input){
        this.setCreateTime(input.getCreateTime());
        this.setAddress(input.getAddress());
        this.setDoorId(input.getDoorId());
        this.setId(input.getId());
        this.setName(input.getName());
        this.setCameraId(input.getCameraId());
    }

    public String getDoorName() {
        return doorName;
    }

    public void setDoorName(String doorName) {
        this.doorName = doorName;
    }
}
