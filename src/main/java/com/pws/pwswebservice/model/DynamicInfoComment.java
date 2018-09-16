package com.pws.pwswebservice.model;

import java.util.Date;

public class DynamicInfoComment {
    private Integer activityCommentId;

    private Integer activityId;

    private Date time;

    private Integer userId;

    private Integer companyId;

    private Integer firstCommentId;

    private Integer likeNumber;

    private String context;

    public Integer getActivityCommentId() {
        return activityCommentId;
    }

    public void setActivityCommentId(Integer activityCommentId) {
        this.activityCommentId = activityCommentId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getFirstCommentId() {
        return firstCommentId;
    }

    public void setFirstCommentId(Integer firstCommentId) {
        this.firstCommentId = firstCommentId;
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