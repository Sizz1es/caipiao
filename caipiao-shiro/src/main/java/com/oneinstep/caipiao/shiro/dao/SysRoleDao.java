package com.oneinstep.caipiao.shiro.dao;

import com.oneinstep.caipiao.core.dao.BaseDao;
import com.oneinstep.caipiao.shiro.entity.SysRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysRoleDao extends BaseDao<Integer,SysRole> {

    /**
     * 通过用户id查询对应角色集合
     * @param uid 用户id
     * @return
     */
    List<SysRole> findRolesByUid(Integer uid);
}
