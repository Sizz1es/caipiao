package com.oneinstep.caipiao.shiro.dao;

import com.oneinstep.caipiao.core.dao.BaseDao;
import com.oneinstep.caipiao.shiro.entity.UserInfo;

public interface UserInfoDao extends BaseDao<Integer,UserInfo> {

    /**
     * 通过用户名查询用户
     * @param username 登录用户名
     * @return
     */
    UserInfo findByUsername(String username);



}
