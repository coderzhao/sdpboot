package com.anytec.sdproperty.data.model;

import java.io.Serializable;
import java.util.Date;

public class TbSnapshotFace implements Serializable {
    private Integer id;

    private Integer snapshotId;

    private String guestCode;

    private Integer ipcId;

    private String galleries;

    private String meta;

    private String photo;

    private Date timestamp;

    private Integer x1;

    private Integer x2;

    private Integer y1;

    private Integer y2;

    private String normalized;

    private Integer age;

    private String thumbnail;

    private String photoHash;

    private Integer personId;

    private Long faceId;

    private String gender;

    private Float confidence;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(Integer snapshotId) {
        this.snapshotId = snapshotId;
    }

    public String getGuestCode() {
        return guestCode;
    }

    public void setGuestCode(String guestCode) {
        this.guestCode = guestCode == null ? null : guestCode.trim();
    }

    public Integer getIpcId() {
        return ipcId;
    }

    public void setIpcId(Integer ipcId) {
        this.ipcId = ipcId;
    }

    public String getGalleries() {
        return galleries;
    }

    public void setGalleries(String galleries) {
        this.galleries = galleries == null ? null : galleries.trim();
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta == null ? null : meta.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getX1() {
        return x1;
    }

    public void setX1(Integer x1) {
        this.x1 = x1;
    }

    public Integer getX2() {
        return x2;
    }

    public void setX2(Integer x2) {
        this.x2 = x2;
    }

    public Integer getY1() {
        return y1;
    }

    public void setY1(Integer y1) {
        this.y1 = y1;
    }

    public Integer getY2() {
        return y2;
    }

    public void setY2(Integer y2) {
        this.y2 = y2;
    }

    public String getNormalized() {
        return normalized;
    }

    public void setNormalized(String normalized) {
        this.normalized = normalized == null ? null : normalized.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail == null ? null : thumbnail.trim();
    }

    public String getPhotoHash() {
        return photoHash;
    }

    public void setPhotoHash(String photoHash) {
        this.photoHash = photoHash == null ? null : photoHash.trim();
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Long getFaceId() {
        return faceId;
    }

    public void setFaceId(Long faceId) {
        this.faceId = faceId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Float getConfidence() {
        return confidence;
    }

    public void setConfidence(Float confidence) {
        this.confidence = confidence;
    }
}