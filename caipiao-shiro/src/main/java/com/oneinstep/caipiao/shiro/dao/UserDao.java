package com.oneinstep.caipiao.shiro.dao;

import com.oneinstep.caipiao.core.dao.BaseDao;
import com.oneinstep.caipiao.shiro.entity.User;

import javax.jws.soap.SOAPBinding;

public interface UserDao extends BaseDao<Integer,User> {

    /**
     * 通过用户名查询用户信息，包括角色和权限
     * @param username 登录用户名
     * @return
     */
    User findForLogin(String username);

    /**
     * 通过用户名和密码查询用户
     * @param userName
     * @param password
     * @return
     */
    User findByNameAndPass(String userName,String password);

    /**
     * 通过用户名修改密码
     * @param userName
     * @param newPass
     * @return
     */
    Integer updatePass(String userName,String newPass);

}
