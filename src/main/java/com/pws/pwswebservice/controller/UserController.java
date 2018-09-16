package com.pws.pwswebservice.controller;

import com.pws.pwswebservice.constants.CommonConstants;
import com.pws.pwswebservice.dto.Role;
import com.pws.pwswebservice.dto.user.UserLoginRequest;
import com.pws.pwswebservice.dto.user.UserLoginResponse;
import com.pws.pwswebservice.model.CommonUser;
import com.pws.pwswebservice.service.IUserService;
import com.pws.pwswebservice.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        String token = tokenService.generateToken(Role.User, commonUser.getUserId());
        response.setToken(token);
        addCookie(CommonConstants.TOKEN_KEY, token);
        return response;
    }
}
