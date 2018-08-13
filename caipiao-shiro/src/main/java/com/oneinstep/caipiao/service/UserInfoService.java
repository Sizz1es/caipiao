package com.oneinstep.caipiao.service;

import com.oneinstep.caipiao.entity.UserInfo;

public interface UserInfoService {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}