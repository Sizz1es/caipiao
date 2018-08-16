package com.oneinstep.caipiao.shiro.service;


import com.oneinstep.caipiao.core.dao.BaseDao;
import com.oneinstep.caipiao.core.service.BaseService;
import com.oneinstep.caipiao.shiro.entity.User;

public interface IUserService extends BaseService<Integer,User> {

    /**通过username查找用户信息;*/
    public User findForLogin(String username);


}