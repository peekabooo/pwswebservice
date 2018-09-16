package com.pws.pwswebservice.service.impl;

import com.pws.pwswebservice.mapper.CommonUserMapper;
import com.pws.pwswebservice.model.CommonUser;
import com.pws.pwswebservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yerunjie on 2018/9/16
 *
 * @author yerunjie
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private CommonUserMapper commonUserMapper;

    @Override
    public CommonUser login(String telephone, String password) {
        CommonUser commonUser = commonUserMapper.findByTelephone(telephone);
        if (commonUser == null || !commonUser.getPassword().equals(password)) {
            return null;
        }
        return commonUser;
    }
}

