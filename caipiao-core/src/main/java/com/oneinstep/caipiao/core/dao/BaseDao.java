package com.oneinstep.caipiao.core.dao;

import org.apache.ibatis.session.SqlSessionException;

import java.util.List;

/**
 * DAO层父接口
 * @author henry_shaw
 * @param <K>
 * @param <V>
 */
public interface BaseDao<K,V> {

    /**
     * 添加数据
     * @param v 包含了要添加的数据的的信息的vo对象
     * @return 受影响的数据条数
     * @throws Exception
     */
    public Integer doCreate(V v);
    /**
     * 根据id更新数据
     * @param v 包含了要修改的数据的的信息的vo对象
     * @return 受影响的数据条数
     * @throws Exception
     */
    public Integer doUpdate(V v);

    /**
     * 查询所有
     * @return 包含了所有查询到的数据的vo对象的集合
     * @throws Exception
     */
    public List<V> findAll();

    /**
     * 查询所有数据量
     * @return 所有的数据的条数
     * @throws Exception
     */
    public Integer getAllCount();

    /**
     * 根据编号进行批量删除
     * @param ids 包含了要删除的数据的编号的数组
     * @return 受影响的数据条数
     * @throws Exception
     */
    public Integer doRemoveBatch(List<K> ids);

    /**
     * 分页查询
     * @param start 开始查询数据的下标
     * @param ls 每页显示数据条数
     * @return 分页数据
     * @throws Exception
     */
    public List<V> findAllSplit(Integer start, Integer ls);

    /**
     * 通过ID进行查询
     * @param k id主键
     * @return 实体
     * @throws Exception
     */
    public V findById(K k);

    /**
     * 通过UID进行查询
     * @param uid 表数据uid
     * @return 实体
     * @throws Exception
     */
    public V findByUid(String uid);

}
