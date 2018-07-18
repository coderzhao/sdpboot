package com.anytec.sdproperty.data.model;

import java.io.Serializable;
import java.util.Date;

public class TbGuest implements Serializable {
    private Integer id;

    private String image;

    private String code;

    private Integer guestRoleId;

    private Date firstTime;

    private Date lastTime;

    private Date createTime;

    private String name;

    private String cardNo;

    private Integer accessGuestId;

    private Integer age;

    private Integer gender;

    private String room;

    private Integer count;

    private Date lockStartTime;

    private Date lockEndTime;

    private String uploadImage;

    private Integer userIdCreate;

    private Integer lastModifyUserId;

    private Date lastModifyTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getGuestRoleId() {
        return guestRoleId;
    }

    public void setGuestRoleId(Integer guestRoleId) {
        this.guestRoleId = guestRoleId;
    }

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public Integer getAccessGuestId() {
        return accessGuestId;
    }

    public void setAccessGuestId(Integer accessGuestId) {
        this.accessGuestId = accessGuestId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room == null ? null : room.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getLockStartTime() {
        return lockStartTime;
    }

    public void setLockStartTime(Date lockStartTime) {
        this.lockStartTime = lockStartTime;
    }

    public Date getLockEndTime() {
        return lockEndTime;
    }

    public void setLockEndTime(Date lockEndTime) {
        this.lockEndTime = lockEndTime;
    }

    public String getUploadImage() {
        return uploadImage;
    }

    public void setUploadImage(String uploadImage) {
        this.uploadImage = uploadImage == null ? null : uploadImage.trim();
    }

    public Integer getUserIdCreate() {
        return userIdCreate;
    }

    public void setUserIdCreate(Integer userIdCreate) {
        this.userIdCreate = userIdCreate;
    }

    public Integer getLastModifyUserId() {
        return lastModifyUserId;
    }

    public void setLastModifyUserId(Integer lastModifyUserId) {
        this.lastModifyUserId = lastModifyUserId;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
}