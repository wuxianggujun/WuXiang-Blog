package com.wuxianggujun.wuxiangblog.entity;

/**
 * 图片
 *
 * @author 无相孤君
 * @date 2022/06/17
 */
public class Picture {
    /**
     * id
     */
    private Long id;
    /**
     * 照片名字
     */
    private String pictureName;
    /**
     * 照片时间
     */
    private String pictureTime;
    /**
     * 图片地址
     */
    private String pictureAddress;
    /**
     * 图片描述
     */
    private String pictureDescription;

    public Picture() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getPictureTime() {
        return pictureTime;
    }

    public void setPictureTime(String pictureTime) {
        this.pictureTime = pictureTime;
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }

    public String getPictureDescription() {
        return pictureDescription;
    }

    public void setPictureDescription(String pictureDescription) {
        this.pictureDescription = pictureDescription;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", pictureName='" + pictureName + '\'' +
                ", pictureTime='" + pictureTime + '\'' +
                ", pictureAddress='" + pictureAddress + '\'' +
                ", pictureDescription='" + pictureDescription + '\'' +
                '}';
    }
}
