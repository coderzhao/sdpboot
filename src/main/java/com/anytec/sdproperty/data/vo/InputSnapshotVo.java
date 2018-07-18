package com.anytec.sdproperty.data.vo;

import java.io.Serializable;
import java.util.List;

/**
 *  人脸识别sdk请求到服务器端的数据类型
 */
public class InputSnapshotVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String camera_id;
    private Integer ipc_id;
    private Integer door_id;
    private String snap_timestamp;
    private InputSnapshotFaceVo face;
    private String snapshot_photo;
    private Integer gusetCode;

    public String getCamera_id() {
        return camera_id;
    }

    public void setCamera_id(String camera_id) {
        this.camera_id = camera_id;
    }

    public Integer getIpc_id() {
        return ipc_id;
    }

    public void setIpc_id(Integer ipc_id) {
        this.ipc_id = ipc_id;
    }
    public Integer getDoor_id() {
        return door_id;
    }

    public void setDoor_id(Integer door_id) {
        this.door_id = door_id;
    }

    public String getSnap_timestamp() {
        return snap_timestamp;
    }

    public void setSnap_timestamp(String snap_timestamp) {
        this.snap_timestamp = snap_timestamp;
    }

    public InputSnapshotFaceVo getFace() {
        return face;
    }

    public void setFace(InputSnapshotFaceVo face) {
        this.face = face;
    }

    public String getSnapshot_photo() {
        return snapshot_photo;
    }

    public void setSnapshot_photo(String snapshot_photo) {
        this.snapshot_photo = snapshot_photo;
    }

    public Integer getGusetCode() {
        return gusetCode;
    }

    public void setGusetCode(Integer gusetCode) {
        this.gusetCode = gusetCode;
    }


}
