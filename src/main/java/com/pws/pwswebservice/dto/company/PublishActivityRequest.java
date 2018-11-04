package com.pws.pwswebservice.dto.company;

import com.pws.pwswebservice.dto.Token;

import java.util.Date;

public class PublishActivityRequest {
    private Token token;
    private String activityName;
    private int typeId ;
    private String description;
    private String desText;
    private String registrationText;
    private Date deadline;
    private Date quitTime;
    private Date publishTime;
    private int status;
    private String uploadText;

    public Token getToken() {
        return token;
    }

    public Date getDeadline() {
        return deadline;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public Date getQuitTime() {
        return quitTime;
    }

    public int getStatus() {
        return status;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getActivityName() {
        return activityName;
    }

    public String getDescription() {
        return description;
    }

    public String getDesText() {
        return desText;
    }

    public String getRegistrationText() {
        return registrationText;
    }

    public String getUploadText() {
        return uploadText;
    }
}
