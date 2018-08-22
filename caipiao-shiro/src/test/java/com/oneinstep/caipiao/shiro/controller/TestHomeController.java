package com.oneinstep.caipiao.shiro.controller;

import com.oneinstep.caipiao.shiro.DockerShiroApplication;
import com.sun.deploy.net.HttpResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DockerShiroApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT   )
@EnableAutoConfiguration
public class TestHomeController {

   @Resource
    RestTemplate restTemplate;

    @Before
    public void setUp() {
        System.out.println("start test...");
    }

    @Test
    public void testHomeController(){
       // HttpHeaders httpHeaders = new HttpHeaders();
        //httpHeaders.add("token","xxxxxx");
       // MultiValueMap multiValueMap = new LinkedMultiValueMap();
        //multiValueMap.add("name","xiaoyao");
       // HttpEntity httpEntity = new HttpEntity(multiValueMap);
       // String[] urlVariables = new String[]{"admin"};
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/",String.class);
        Assert.assertEquals(responseEntity.getStatusCode(),200);
    }

}
