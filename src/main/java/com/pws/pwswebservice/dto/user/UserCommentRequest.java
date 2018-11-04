package com.pws.pwswebservice.dto.user;

import com.pws.pwswebservice.dto.Token;
import com.pws.pwswebservice.model.ActivityComment;
import lombok.Data;

@Data
public class UserCommentRequest {
    private int userId;
    private int companyId;
    private int activityId;
    private String context;
    private Token token;

    public Token getToken() {
        return token;
    }

    public int getUserId() {
        return userId;
    }

    public int getActivityId() {
        return activityId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getContext() {
        return context;
    }
}
