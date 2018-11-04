package com.pws.pwswebservice.service;

import com.pws.pwswebservice.model.ActivityComment;
import com.pws.pwswebservice.model.CommonUser;

/**
 * Created by yerunjie on 2018/9/16
 *
 * @author yerunjie
 */
public interface IUserService {
    CommonUser login(String telephone, String password);
    int register(String telephone, String password);
    int commentActivityMain(int userId,int companyId,int activityInfoId,String context);
    void collect(int userId,int activityId);
    void joinActivity(int userId,int activityId,String comment);
    void modifyPersonalInfo(int userId,String nickName,String realName,String studentId,int gender,String department,String university,String info);
    void joinGroup(int userId,int groupId);
}
