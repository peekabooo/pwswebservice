/*
package com.pws.pwswebservice.service.impl;

import com.pws.pwswebservice.model.CommonUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userServiceIpml;

    @Test
    public void login() throws Exception {

    }

    @Test
    public void register() throws Exception {
        CommonUser user = new CommonUser();
        user.setTelephone("15317838616");
        user.setPassword("0000");
        int response = userServiceIpml.register(user);
        Assert.assertEquals(response,0);
    }

}*/
