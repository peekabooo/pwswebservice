package com.pws.pwswebservice.dto.user;


import com.pws.pwswebservice.dto.Token;

public class UserModifyPersonalInfoRequest {
    private String nickName;

    private String realName;//文本为空传空字符串

    private Integer gender;//必填

    private String university;

    private String department;

    private String studentId;//必填

    private Integer point;

    private String personalInformation;

    private Token token;


    public Integer getGender() {
        return gender;
    }

    public Integer getPoint() {
        return point;
    }

    public String getDepartment() {
        return department;
    }

    public String getNickName() {
        return nickName;
    }

    public String getRealName() {
        return realName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getUniversity() {
        return university;
    }

    public String getPersonalInformation() {
        return personalInformation;
    }

    public Token getToken() {
        return token;
    }
}
