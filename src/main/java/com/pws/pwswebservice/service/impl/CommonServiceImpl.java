package com.pws.pwswebservice.service.impl;

import com.pws.pwswebservice.mapper.*;
import com.pws.pwswebservice.model.*;
import com.pws.pwswebservice.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommonServiceImpl implements ICommonService {
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private ActivityCommentMapper activityCommentMapper;
    @Autowired
    private JoinActivityMapper joinActivityMapper;
    @Autowired
    private CommonUserMapper commonUserMapper;
    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public List<Activity> displayActivityInfo(int sortMethod,int sortTag) {
        List<Activity> activities = new ArrayList<>();
        if(sortTag==0){
            switch (sortMethod){
                case 0:activities = activityMapper.selectAllAsc();
                case 1:activities = activityMapper.selectAllDesc();
            }
        }else {
            switch (sortMethod){
                case 0:activities = activityMapper.selectByTagAsc(sortTag);
                case 1:activities = activityMapper.selectByTagDesc(sortTag);
            }
        }
        return activities;
    }

    @Override
    public List<ActivityComment> displayMainComment(int activityId) {
        List<ActivityComment> activityComments = new ArrayList<>();
        activityComments = activityCommentMapper.selectByActivityId(activityId);
        return activityComments;
    }

    @Override
    public List<JoinActivity> displayHistoryActivity(int userId) {
        List<JoinActivity> activities = new ArrayList<>();
        activities = joinActivityMapper.selectByUserId(userId);
        return activities;
    }

    @Override
    public CommonUser displayUserInfo(int userId) {
        return commonUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<CollectionKey> displayCollection(int userId) {
        List<CollectionKey> activities = collectionMapper.selectByPrimaryKey(userId);
        return activities;
    }
}
