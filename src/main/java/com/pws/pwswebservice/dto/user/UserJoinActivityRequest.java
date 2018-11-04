package com.pws.pwswebservice.dto.user;

import com.pws.pwswebservice.dto.Token;

public class UserJoinActivityRequest {
    private int activityId;
    private String comment;
    private Token token;

    public int getActivityId() {
        return activityId;
    }

    public String getComment() {
        return comment;
    }

    public Token getToken() {
        return token;
    }
}
