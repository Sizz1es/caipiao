package com.oneinstep.caipiao.shiro.controller;

import com.oneinstep.caipiao.shiro.DockerShiroApplication;
import com.oneinstep.caipiao.shiro.service.IUserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DockerShiroApplication.class)
public class TestUserController {

    @Resource
    RestTemplate restTemplate;

    public  void testUserController(){

    }

}
