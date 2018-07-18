package com.anytec.sdproperty.data.vo;

import com.anytec.sdproperty.data.model.TbGuest;
import com.anytec.sdproperty.data.model.TbSnapshot;

import java.io.Serializable;
import java.util.List;

/**
 *  人脸识别sdk请求到服务器端的数据类型
 */
public class OutputSnapshotVo implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer snapshotId; //靠这个来识别顺序和前后关系
    private String name;//访客姓名
    private String  roleName;//角色名称
    private Integer securityLevel;//角色安全等级，分为1-安全，2-警告，3-危险，4-未知
    private String  photo;//头像 url
    private String  orginPhoto;//图库中的源头像 url
    private Integer ipcId;//摄像头id
    private Integer age;//
    private String createTime;//创建时间
    private String guestCode;//头像编码
    private Float confidence;

    private String ipcName;
    private TbGuest guest;//最危险的那个人的访客信息
    private List<OutputSnapshotFaceVo> faces;
    private TbSnapshot snapshot;

    public String getIpcName() {
        return ipcName;
    }

    public void setIpcName(String ipcName) {
        this.ipcName = ipcName;
    }

    public TbGuest getGuest() {
        return guest;
    }

    public void setGuest(TbGuest guest) {
        this.guest = guest;
    }

    public List<OutputSnapshotFaceVo> getFaces() {
        return faces;
    }

    public void setFaces(List<OutputSnapshotFaceVo> faces) {
        this.faces = faces;
    }

    public TbSnapshot getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(TbSnapshot snapshot) {
        this.snapshot = snapshot;
    }

    public Integer getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(Integer snapshotId) {
        this.snapshotId = snapshotId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getIpcId() {
        return ipcId;
    }

    public void setIpcId(Integer ipcId) {
        this.ipcId = ipcId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGuestCode() {
        return guestCode;
    }

    public void setGuestCode(String guestCode) {
        this.guestCode = guestCode;
    }

    public Float getConfidence() {
        return confidence;
    }

    public void setConfidence(Float confidence) {
        this.confidence = confidence;
    }

    public String getOrginPhoto() {
        return orginPhoto;
    }

    public void setOrginPhoto(String orginPhoto) {
        this.orginPhoto = orginPhoto;
    }

    public Integer getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(Integer securityLevel) {
        this.securityLevel = securityLevel;
    }
}
