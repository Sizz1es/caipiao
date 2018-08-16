package com.oneinstep.caipiao.shiro.service;

import com.oneinstep.caipiao.shiro.SpringBootShiroApplication;
import com.oneinstep.caipiao.shiro.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootShiroApplication.class)
public class TestUserService {

    @Resource
    private IUserService userService;

    @Test
    public void testfindForLogin(){
        User user = userService.findForLogin("admin");
        System.out.println(user);
    }
}
