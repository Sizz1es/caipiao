package com.oneinstep.caipiao.shiro.service.impl;

import com.oneinstep.caipiao.shiro.dao.UserDao;
import com.oneinstep.caipiao.shiro.entity.User;
import com.oneinstep.caipiao.shiro.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
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
    public boolean save(User user) {
        return userDao.doCreate(user)>0;
    }

    @Override
    public User findById(Integer uid) {
        return userDao.findById(uid);
    }

    @Override
    public boolean update(User user) {
        return userDao.doUpdate(user)>0;
    }

    @Override
    public boolean delete(Integer uid) {
        return userDao.doRemove(uid)>0;
    }

    @Override
    public boolean updatePass(Integer uid, String newPass) {
        return userDao.setPass(uid,newPass)>0;
    }


}