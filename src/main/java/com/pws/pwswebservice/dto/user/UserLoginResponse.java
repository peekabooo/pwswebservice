package com.pws.pwswebservice.dto.user;

import com.pws.pwswebservice.dto.BaseJsonResponse;
import com.pws.pwswebservice.dto.Token;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by yerunjie on 2018/9/16
 *
 * @author yerunjie
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserLoginResponse extends BaseJsonResponse {
    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String getReturnCode() {
        return super.getReturnCode();
    }

    @Override
    public String getReturnMsg() {
        return super.getReturnMsg();
    }
}
