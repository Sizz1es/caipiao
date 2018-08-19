package com.oneinstep.caipiao.shiro.service;


import com.oneinstep.caipiao.core.base.dao.BaseDao;
import com.oneinstep.caipiao.core.base.service.BaseService;
import com.oneinstep.caipiao.shiro.entity.User;

public interface IUserService extends BaseService<Integer,User> {

    /**通过username查找用户信息;*/
    public User findForLogin(String userName);


    /**
     * 修改账号密码
     * @param uid 用户id
     * @param newPass 新密码
     * @return
     */
    boolean updatePass(Integer uid,String newPass);


}