package com.anytec.sdproperty.data.vo;

import com.anytec.sdproperty.data.model.TbGuest;
import com.anytec.sdproperty.data.model.TbSnapshotFace;

import java.io.Serializable;

/**
 *  一个识别的快照中的某一个人的输出返回数据，包含人脸信息和访客信息
 */
public class OutputSnapshotFaceVo implements Serializable {
    private static final long serialVersionUID = 1L;
    TbGuest guest;
    TbSnapshotFace face;

    public TbGuest getGuest() {
        return guest;
    }

    public void setGuest(TbGuest guest) {
        this.guest = guest;
    }

    public TbSnapshotFace getFace() {
        return face;
    }

    public void setFace(TbSnapshotFace face) {
        this.face = face;
    }

    public Integer getRoleId(){
        if(guest != null){
            return guest.getGuestRoleId();
        }
        return null;
    }

    public String getName(){
        String name = "未知";
        if(guest != null){
            if(null != guest.getName()){
                name = guest.getName();
            }
        }
        return name;
    }
}
