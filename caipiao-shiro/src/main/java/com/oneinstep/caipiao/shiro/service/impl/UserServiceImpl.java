package com.oneinstep.caipiao.shiro.service.impl;

import com.oneinstep.caipiao.shiro.dao.UserDao;
import com.oneinstep.caipiao.shiro.entity.User;
import com.oneinstep.caipiao.shiro.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserDao userDao;

    @Override
    public User findForLogin(String username) {
        return userDao.findForLogin(username);
    }

}