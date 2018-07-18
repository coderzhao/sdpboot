package com.anytec.sdproperty.data.vo;

import com.anytec.sdproperty.data.model.TbSnapshotFace;

import java.io.Serializable;
import java.util.List;

/**
 *  人脸识别sdk请求到服务器端的数据类型
 */

public class InputSnapshotFaceVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<String> galleries;
    private String meta;
    private String photo;
    private String photo_hash;
    private String gender;
    private Boolean friend;
    private String normalized;
    private String timestamp;
    private String thumbnail;
    private double age;
    private List<String> emotions;
    private  Integer person_id;//私库中个人的id
    private  Long id;
    private Integer x1 ;
    private Integer y1 ;
    private Integer x2 ;
    private Integer y2 ;
    private Float confidence;

    public TbSnapshotFace createSnapshot(){
        TbSnapshotFace self = new TbSnapshotFace();
        self.setX1(x1);
        self.setX2(x2);
        self.setY1(y1);
        self.setY2(y2);
        self.setPhoto(photo);
//        self.setTimestamp(timestamp);
        self.setMeta(meta);
        int agen = (int)age;
        self.setAge(agen);
        self.setFaceId(id);
        self.setPersonId(person_id);
        String strgalleries = "";
        if(galleries != null && galleries.size() > 0){
            for(String item : galleries){
                strgalleries += item + ",";
            }
        }
        self.setGalleries(strgalleries);
        self.setThumbnail(thumbnail);
        self.setGender(gender);
        self.setNormalized(normalized);
        self.setPhotoHash(photo_hash);
        self.setConfidence(confidence);

        return self;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getX1() {
        return x1;
    }

    public void setX1(Integer x1) {
        this.x1 = x1;
    }

    public Integer getY1() {
        return y1;
    }

    public void setY1(Integer y1) {
        this.y1 = y1;
    }

    public Integer getX2() {
        return x2;
    }

    public void setX2(Integer x2) {
        this.x2 = x2;
    }

    public Integer getY2() {
        return y2;
    }

    public void setY2(Integer y2) {
        this.y2 = y2;
    }

    public List<String> getGalleries() {
        return galleries;
    }

    public void setGalleries(List<String> galleries) {
        this.galleries = galleries;
    }

    public String getPhoto_hash() {
        return photo_hash;
    }

    public void setPhoto_hash(String photo_hash) {
        this.photo_hash = photo_hash;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean isFriend() {
        return friend;
    }

    public void setFriend(Boolean friend) {
        this.friend = friend;
    }

    public String getNormalized() {
        return normalized;
    }

    public void setNormalized(String normalized) {
        this.normalized = normalized;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public List<String> getEmotions() {
        return emotions;
    }

    public void setEmotions(List<String> emotions) {
        this.emotions = emotions;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getConfidence() {
        return confidence;
    }

    public void setConfidence(Float confidence) {
        this.confidence = confidence;
    }
}
