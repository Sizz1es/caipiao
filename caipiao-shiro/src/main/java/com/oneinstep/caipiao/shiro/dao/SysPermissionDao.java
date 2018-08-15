package com.oneinstep.caipiao.shiro.dao;

import com.oneinstep.caipiao.core.dao.BaseDao;
import com.oneinstep.caipiao.shiro.entity.SysPermission;

import java.util.List;

public interface SysPermissionDao extends BaseDao<Integer,SysPermission> {


    List<SysPermission> findPermissionsByRid(Integer rid);

}
