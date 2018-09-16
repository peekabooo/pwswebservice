package com.pws.pwswebservice.service;

import com.pws.pwswebservice.model.CommonUser;

/**
 * Created by yerunjie on 2018/9/16
 *
 * @author yerunjie
 */
public interface IUserService {
    CommonUser login(String telephone, String password);
}
