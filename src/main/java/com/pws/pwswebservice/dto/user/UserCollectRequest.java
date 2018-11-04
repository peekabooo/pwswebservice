package com.pws.pwswebservice.dto.user;

import com.pws.pwswebservice.dto.BaseJsonResponse;
import com.pws.pwswebservice.dto.Token;

public class UserCollectRequest {
    private Token token;
    private int activityId;

    public Token getToken() {
        return token;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
