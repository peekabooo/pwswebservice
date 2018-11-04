package com.pws.pwswebservice.dto.user;

import lombok.Data;

/**
 * Created by yerunjie on 2018/9/16
 *
 * @author yerunjie
 */
@Data
public class UserLoginRequest {
    private String telephone;
    private String password;

    public String getPassword() {
        return password;
    }

    public String getTelephone() {
        return telephone;
    }

}
