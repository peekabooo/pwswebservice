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

    public CommonUser(){

    }

    public Integer getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public void setLevel(BigDecimal level) {
        this.level = level;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setPersonalInformation(String personalInformation) {
        this.personalInformation = personalInformation;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}