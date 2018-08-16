package com.oneinstep.caipiao.shiro.service.impl;

import com.oneinstep.caipiao.shiro.dao.UserDao;
import com.oneinstep.caipiao.shiro.entity.User;
import com.oneinstep.caipiao.shiro.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserDao userDao;

    @Override
    public User findForLogin(String username) {
        return userDao.findForLogin(username);
    }


    @Override
    public List<User> list() {
        return userDao.findAll();
    }

    @Override
    public Integer save(User user) {
        return userDao.doCreate(user);
    }

    @Override
    public User findById(Integer uid) {
        return userDao.findById(uid);
    }

    @Override
    public Integer update(User user) {
        return userDao.doUpdate(user);
    }

    @Override
    public Integer delete(Integer uid) {
        return userDao.doRemove(uid);
    }
}