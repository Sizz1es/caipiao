package com.oneinstep.caipiao.shiro.dao;

import com.oneinstep.caipiao.core.dao.BaseDao;
import com.oneinstep.caipiao.shiro.entity.SysRole;

import java.util.List;

public interface SysRoleDao extends BaseDao<Integer,SysRole> {

    List<SysRole> findRolesByUid(Integer uid);
}
