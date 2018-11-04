package com.pws.pwswebservice.dto.common;

import com.pws.pwswebservice.dto.Token;

public class GetMyCollectionRequest {
    private Token token;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
