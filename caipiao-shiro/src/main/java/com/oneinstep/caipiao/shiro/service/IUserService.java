package com.oneinstep.caipiao.shiro.service;


import com.oneinstep.caipiao.shiro.entity.User;

public interface IUserService {

    /**通过username查找用户信息;*/
    public User findForLogin(String username);
}