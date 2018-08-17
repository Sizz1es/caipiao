package com.oneinstep.caipiao.shiro.service;


import com.oneinstep.caipiao.core.dao.BaseDao;
import com.oneinstep.caipiao.core.service.BaseService;
import com.oneinstep.caipiao.shiro.entity.User;

public interface IUserService extends BaseService<Integer,User> {

    /**通过username查找用户信息;*/
    public User findForLogin(String userName);

    /**
     * 通过用户名和密码查询用户
     * @param userName
     * @param password
     * @return
     */
    User findByNameAndPass(String userName,String password);

    /**
     * 修改账号密码
     * @param userName 账号
     * @param newPass 新密码
     * @return
     */
    boolean updatePass(String userName,String newPass);


}