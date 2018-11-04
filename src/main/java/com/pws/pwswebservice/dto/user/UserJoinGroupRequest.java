package com.pws.pwswebservice.dto.user;

import com.pws.pwswebservice.dto.Token;

public class UserJoinGroupRequest {
    private Token token;
    private Integer groupId;

    public Token getToken() {
        return token;
    }

    public Integer getGroupId() {
        return groupId;
    }

}
