package com.pws.pwswebservice.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CommonUser {
    private Integer userId;

    private String nickName;

    private String realName;

    private Byte gender;

    private String telephone;

    private String university;

    private String department;

    private String studentId;

    private Integer point;

    private BigDecimal level;

    private String password;

    private String personalInformation;

}