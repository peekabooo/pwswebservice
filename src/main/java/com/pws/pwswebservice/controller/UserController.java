package com.pws.pwswebservice.controller;

import com.pws.pwswebservice.constants.CommonConstants;
import com.pws.pwswebservice.dto.BaseJsonResponse;
import com.pws.pwswebservice.dto.Role;
import com.pws.pwswebservice.dto.Token;
import com.pws.pwswebservice.dto.user.*;
import com.pws.pwswebservice.model.CommonUser;
import com.pws.pwswebservice.service.IUserService;
import com.pws.pwswebservice.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yerunjie on 2018/9/16
 *
 * @author yerunjie
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserLoginResponse login(@RequestBody UserLoginRequest request) {
        UserLoginResponse response = new UserLoginResponse();
        CommonUser commonUser = userService.login(request.getTelephone(), request.getPassword());
        if(commonUser!=null) {
            String token = tokenService.generateToken(Role.User, commonUser.getUserId());
            response.setToken(token);
            addCookie(CommonConstants.TOKEN_KEY, token);
            response.setReturnCode("LS");
            response.setReturnMsg("成功");
        }
        else {
            response.setReturnCode("LF");
            response.setReturnMsg("失败");
        }
        return response;
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public UserRegisterResponse register(@RequestBody UserRegisterRequest request){
        String token;
        UserRegisterResponse response = new UserRegisterResponse();
        int registerCode = userService.register(request.getTelephone(),request.getPassword());
        if(registerCode==0) {//该账号已经注册
            response.setReturnCode("RF");
            response.setReturnMsg("该账号已经注册");
        }
        else {
            token = tokenService.generateToken(Role.User, registerCode);
            response.setToken(token);
            addCookie(CommonConstants.TOKEN_KEY,token);
            response.setReturnCode("RS");
            response.setReturnMsg("成功"+"  "+registerCode);
        }
        return response;
    }

    @RequestMapping(value="/commentActivityMain", method = RequestMethod.POST)
    public UserCommentResponse comment(@RequestBody UserCommentRequest request){
        UserCommentResponse response = new UserCommentResponse();
        if(request.getToken()==null){
            response.setReturnCode("NL");
            response.setReturnMsg("还未登录");
        }
        else {
            int userId = request.getToken().getId();
            int result = userService.commentActivityMain(userId, request.getCompanyId(), request.getActivityId(), request.getContext());
            if (result != 0) {
                response.setReturnCode("CS");
                response.setReturnMsg("评论成功");
            }
        }
        return response;
    }

    @RequestMapping(value="/collect",method = RequestMethod.POST)
    public UserCollectResponse collect(@RequestBody UserCollectRequest request){
        UserCollectResponse response = new UserCollectResponse();
        Token token = request.getToken();
        if(token==null){
            response.setReturnCode("NL");
            response.setReturnMsg("还未登录");
        }
        else{
            int userId = token.getId();
            userService.collect(userId,request.getActivityId());
            response.setReturnCode("CollectSucc");
            response.setReturnMsg("收藏成功");
        }
        return response;
    }

    @RequestMapping(value="/joinActivity",method = RequestMethod.POST)
    public UserJoinActivityResponse joinActivity(@RequestBody UserJoinActivityRequest request){
        UserJoinActivityResponse response = new UserJoinActivityResponse();
        Token token = request.getToken();
        if(token==null){
            response.setReturnCode("NL");
            response.setReturnMsg("还未登录");
        }
        else{
            int userId = token.getId();
            userService.joinActivity(userId,request.getActivityId(),request.getComment());
            response.setReturnCode("JoinSucc");
            response.setReturnMsg("加入活动成功");
        }
        return response;


    }

    @RequestMapping(value = "/modifyPersonalInfo",method = RequestMethod.POST)
    public UserModifyPersonalInfoResponse modifyPersonalInfo(@RequestBody UserModifyPersonalInfoRequest request){
        UserModifyPersonalInfoResponse response = new UserModifyPersonalInfoResponse();
        Token token = request.getToken();
        if(token == null){
            response.setReturnCode("NL");
            response.setReturnMsg("还未登录");
        }
        else {
            int userId = token.getId();
            String nickName = request.getNickName();
            String department = request.getDepartment();
            int gender = request.getGender();
            String info = request.getPersonalInformation();
            String realName = request.getRealName();
            String studentId = request.getStudentId();
            String university = request.getUniversity();
            userService.modifyPersonalInfo(userId,nickName,realName,studentId,gender,department,university,info);
            response.setReturnCode("ModifySucc");
            response.setReturnMsg("修改成功");

        }
        return response;
    }

    @RequestMapping(value = "joinGroup",method = RequestMethod.POST)
    public UserJoinGroupResponse joinGroup(@RequestBody UserJoinGroupRequest request){
        UserJoinGroupResponse response = new UserJoinGroupResponse();
        Token token = request.getToken();
        request.getGroupId();
        if(token == null){
            response.setReturnCode("NL");
            response.setReturnMsg("还未登录");
        }
        else{
            int groupId = request.getGroupId();
            int userId = token.getId();
            userService.joinGroup(userId,groupId);
            response.setReturnCode("joinSucc");
            response.setReturnMsg("加入成功");
        }
        return response;
    }



}