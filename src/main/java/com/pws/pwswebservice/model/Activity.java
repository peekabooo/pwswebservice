package com.pws.pwswebservice.model;

import java.util.Date;

public class Activity {
    private Integer activityId;

    private String activityName;

    private Integer typeId;

    private Integer companyId;

    private String desText;

    private String registrationText;

    private Date deadline;

    private Date quitTime;

    private Date publishTime;

    private Byte status;

    private String uploadText;

    private String description;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getDesText() {
        return desText;
    }

    public void setDesText(String desText) {
        this.desText = desText == null ? null : desText.trim();
    }

    public String getRegistrationText() {
        return registrationText;
    }

    public void setRegistrationText(String registrationText) {
        this.registrationText = registrationText == null ? null : registrationText.trim();
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getQuitTime() {
        return quitTime;
    }

    public void setQuitTime(Date quitTime) {
        this.quitTime = quitTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getUploadText() {
        return uploadText;
    }

    public void setUploadText(String uploadText) {
        this.uploadText = uploadText == null ? null : uploadText.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}