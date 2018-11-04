package com.pws.pwswebservice.dto.common;

import com.pws.pwswebservice.dto.Token;

public class GetUserInfoRequest {
    private Token token;

    public void setToken(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }
}
