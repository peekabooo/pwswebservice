package com.pws.pwswebservice.dto.user;

import com.pws.pwswebservice.model.CommonUser;
import lombok.Data;

@Data
public class UserRegisterRequest {
    private String telephone;

    private String password;

    public String getTelephone() {
        return telephone;
    }

    public String getPassword() {
        return password;
    }
}
