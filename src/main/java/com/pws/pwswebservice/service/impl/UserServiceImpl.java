package com.pws.pwswebservice.service.impl;

import com.pws.pwswebservice.mapper.*;
import com.pws.pwswebservice.model.*;
import com.pws.pwswebservice.service.IUserService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yerunjie on 2018/9/16
 *
 * @author yerunjie
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private CommonUserMapper commonUserMapper;
    @Autowired
    private ActivityCommentMapper activityCommentMapper;
    @Autowired
    private CollectionMapper collectionMapper;
    @Autowired
    private JoinActivityMapper joinActivityMapper;
    @Autowired
    private GroupMemberMapper groupMemberMapper;

    @Override
    public CommonUser login(String telephone, String password) {
        CommonUser commonUser = commonUserMapper.findByTelephone(telephone);
        if (commonUser == null || !commonUser.getPassword().equals(password)) {
            return null;
        }
        return commonUser;
    }

    @Override
    public int register(String telephone, String password){
        int result;
        CommonUser commonUser = new CommonUser();
        commonUser.setTelephone(telephone);
        commonUser.setPassword(password);
        commonUser.setPersonalInformation("");

        if(commonUserMapper.findRecordByTelephone(telephone)!=null)
            result=0;
        else {
            commonUserMapper.registerInsert(commonUser);
            result=commonUser.getUserId();
        }
        return result;
    }

    @Override
    public int commentActivityMain(int userId,int companyId,int activityId,String context){
        ActivityComment activityComment = new ActivityComment();
        activityComment.setCompanyId(companyId);
        activityComment.setContext(context);
        activityComment.setFirstCommentId(0);
        activityComment.setTime(new Date());
        activityComment.setUserId(userId);
        activityComment.setActivityId(activityId);
        int result=activityCommentMapper.insertMainComment(activityComment);
        return result;
    }

    @Override
    public void collect(int userId,int activityId){
        CollectionKey collection = new CollectionKey();
        collection.setActivityId(activityId);
        collection.setUserId(userId);
        collectionMapper.insert(collection);

    }

    @Override
    public void joinActivity(int userId,int activityId,String comment){
        JoinActivity joinActivity = new JoinActivity();
        joinActivity.setUserId(userId);
        joinActivity.setActivityId(activityId);
        joinActivity.setStatus(0);
        joinActivity.setComment(comment);
        joinActivityMapper.insert(joinActivity);
    }

    @Override
    public void modifyPersonalInfo(int userId,String nickName,String realName,String studentId,int gender,String department,String university,String info){
        commonUserMapper.modifyInfo(userId, nickName, realName, studentId, gender, department,university, info);
    }

    @Override
    public void joinGroup(int userId,int groupId){
        GroupMemberKey memberKey = new GroupMemberKey();
        memberKey.setUserId(userId);
        memberKey.setGroupId(groupId);
        groupMemberMapper.insert(memberKey);
    }
}

