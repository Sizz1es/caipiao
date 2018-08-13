package com.oneinstep.service.impl;

import com.oneinstep.dao.UserInfoDao;
import com.oneinstep.entity.UserInfo;
import com.oneinstep.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}