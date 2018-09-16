package com.pws.pwswebservice.model;

import lombok.Data;

@Data
public class Company {
    private Integer companyId;

    private String companyName;

    private String telephone;

    private String address;

    private String email;

}