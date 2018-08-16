package com.oneinstep.caipiao.shiro.dao;

import com.oneinstep.caipiao.core.dao.BaseDao;
import com.oneinstep.caipiao.shiro.entity.SysPermission;

import java.util.List;

public interface SysPermissionDao extends BaseDao<Integer,SysPermission> {

    /**
     * 通过角色id查找对应权限集合
     * @param rid 角色id
     * @return
     */
    List<SysPermission> findPermissionsByRid(Integer rid);

}
