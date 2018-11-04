package com.pws.pwswebservice.dto.user;

import com.pws.pwswebservice.dto.BaseJsonResponse;
import lombok.Data;

@Data
public class UserRegisterResponse extends BaseJsonResponse{
    private String token;

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public void setReturnCode(String returnCode) {
        super.setReturnCode(returnCode);
    }

    @Override
    public void setReturnMsg(String returnMsg) {
        super.setReturnMsg(returnMsg);
    }
}
