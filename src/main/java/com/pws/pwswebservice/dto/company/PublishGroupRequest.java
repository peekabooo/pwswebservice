package com.pws.pwswebservice.dto.company;

import com.pws.pwswebservice.dto.Token;

public class PublishGroupRequest {
    private String groupName;
    private int memberNum;
    private Token token;

    public Token getToken() {
        return token;
    }

    public int getMemberNum() {
        return memberNum;
    }

    public String getGroupName() {
        return groupName;
    }
}
