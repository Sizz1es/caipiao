package com.oneinstep.caipiao.shiro.controller;

import com.oneinstep.caipiao.shiro.DockerShiroApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DockerShiroApplication.class)
public class TestUserController {

    //引入MockMvc支持了对Controller层的测试
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    //验证controller是否正常响应并打印返回结果
    @Test
    public  void getUserController() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/user/list")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    //验证controller是否正常响应并判断返回结果是否正确
    @Test
    public  void testUserController() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/list").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk(http://xucaizxyl.com/))
                .andExpect(content().string(equalTo("Hello World")http://www.wbjyl.cn/));
    }

}
