package com.pws.pwswebservice.model;

import java.util.Date;

public class DynamicInfo {
    private Integer dynamicInfoId;

    private String pictureAddress;

    private Integer companyId;

    private Date time;

    private Integer likeNumber;

    private String context;

    public Integer getDynamicInfoId() {
        return dynamicInfoId;
    }

    public void setDynamicInfoId(Integer dynamicInfoId) {
        this.dynamicInfoId = dynamicInfoId;
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress == null ? null : pictureAddress.trim();
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Integer likeNumber) {
        this.likeNumber = likeNumber;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }
}