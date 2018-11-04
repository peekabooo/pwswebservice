package com.pws.pwswebservice.controller;

import com.pws.pwswebservice.dto.common.*;
import com.pws.pwswebservice.model.Activity;
import com.pws.pwswebservice.model.ActivityComment;
import com.pws.pwswebservice.model.CollectionKey;
import com.pws.pwswebservice.model.JoinActivity;
import com.pws.pwswebservice.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/common")
public class CommonController extends BaseController {
    @Autowired
    private CommonServiceImpl commonService;

    @RequestMapping(value = "/displayActivityInfo", method = RequestMethod.POST)
    public ActivityInfoResponse displayActivityInfo(@RequestBody ActivityInfoRequest request) {
        ActivityInfoResponse response = new ActivityInfoResponse();
        int sortMethod = request.getSortMethod();
        int sortTag = request.getSortMethod();
        List<Activity> activities = commonService.displayActivityInfo(sortMethod,sortTag);
        if (activities.size()==0) {
            response.setActivities(activities);
            response.setReturnCode("findNull");
            response.setReturnMsg("未找到活动");
        } else {
            response.setActivities(activities);
            response.setReturnCode("succ");
            response.setReturnMsg("查询成功");
        }
        return response;
    }

    @RequestMapping(value = "/displayMainComment" ,method = RequestMethod.POST)
    public GetMainCommentResponse displayMainComment(@RequestBody GetMainCommentRequest request){
        GetMainCommentResponse response = new GetMainCommentResponse();
        int activityId = request.getActivityId();
        List<ActivityComment> activityComments = commonService.displayMainComment(activityId);
        if(activityComments.size()==0){
            response.setActivityComment(activityComments);
            response.setReturnCode("findNull");
            response.setReturnMsg("还未评论");
        }
        else {
            response.setActivityComment(activityComments);
            response.setReturnCode("succ");
            response.setReturnMsg("查询成功");
        }
        return response;
    }

    @RequestMapping(value = "/displayHistoryActivity" ,method = RequestMethod.POST)
    public GetHistoryActivityResponse displayHistoryActivity(@RequestBody GetHistoryActivityRequest request){
        GetHistoryActivityResponse response = new GetHistoryActivityResponse();
        List<JoinActivity> activities = new ArrayList<>();
        if(request.getToken()==null){
            response.setReturnCode("NL");
            response.setReturnMsg("还未登录");
        }
        else{
            int userId = request.getToken().getId();
            activities = commonService.displayHistoryActivity(userId);
            if(activities.size()==0){
                response.setActivities(activities);
                response.setReturnCode("findNull");
                response.setReturnMsg("您还未参加活动！");
            }
            else{
                response.setActivities(activities);
                response.setReturnCode("succ");
                response.setReturnMsg("查询成功");
            }

        }
        return response;
    }

    @RequestMapping(value="/displayUserInfo",method = RequestMethod.POST)
    public GetUserInfoResponse displayUserInfo (@RequestBody GetUserInfoRequest request){
        GetUserInfoResponse response = new GetUserInfoResponse();
        if(request.getToken()==null){
            response.setReturnCode("NL");
            response.setReturnMsg("还未登录");
        }
        else{
            int userId = request.getToken().getId();
            response.setCommonUser(commonService.displayUserInfo(userId));
            response.setReturnCode("succ");
            response.setReturnMsg("查询成功！");
        }
        return response;
    }

    @RequestMapping(value="/displayCollection",method = RequestMethod.POST)
    public GetMyCollectionResponse displayCollection (@RequestBody GetMyCollectionRequest request){
        GetMyCollectionResponse response = new GetMyCollectionResponse();
        List<CollectionKey> activities = new ArrayList<>();
        if(request.getToken()==null){
            response.setReturnCode("NL");
            response.setReturnMsg("还未登录");
        }
        else{
            int userId = request.getToken().getId();
            activities = commonService.displayCollection(userId);
            if(activities.size()==0){
                response.setActivities(activities);
                response.setReturnCode("findNull");
                response.setReturnMsg("您还未收藏活动！");
            }
            else {
                response.setActivities(activities);
                response.setReturnCode("succ");
                response.setReturnMsg("查询成功");
            }
        }
        return response;
    }



}
