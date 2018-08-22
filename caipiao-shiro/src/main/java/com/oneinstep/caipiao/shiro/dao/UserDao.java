package com.oneinstep.caipiao.shiro.dao;

import com.oneinstep.caipiao.core.base.dao.BaseDao;
import com.oneinstep.caipiao.shiro.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface UserDao extends BaseDao<Integer,User> {

    /**
     * 通过用户名查询用户信息，包括角色和权限
     * @param username 登录用户名
     * @return
     */
    User findForLogin(String username);

    /**
     * 根据用户id更新用户密码
     * @param uid 用户Id
     * @param newPass 新密码
     * @return
     */
    @Update("update user set password = #{newPass} where  uid = #{uid}")
    int setPass(Integer uid,String newPass);

}
