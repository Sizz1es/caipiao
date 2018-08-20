package com.oneinstep.caipiao.core.base.dao;

import java.util.List;

/**
 * DAO层父接口
 * @author henry.shaw(xiaoyao)
 * @param <K>
 * @param <V>
 */
public interface BaseDao<K,V> {

    /**
     * 添加数据
     * @param v 包含了要添加的数据的的信息的vo对象
     * @return 受影响的数据条数
     */
     Integer doCreate(V v);
    /**
     * 根据id更新数据
     * @param v 包含了要修改的数据的的信息的vo对象
     * @return 受影响的数据条数
     */
     Integer doUpdate(V v);

    /**
     * 根据id删除对象
     * @param k id主键
     * @return 受影响的数据条数
     */
     Integer doRemove(K k);


    /**
     * 查询所有
     * @return 包含了所有查询到的数据的vo对象的集合
     */
     List<V> findAll();


    /**
     * 根据编号进行批量删除
     * @param ids 包含了要删除的数据的编号的数组
     * @return 受影响的数据条数
     */
     Integer doRemoveBatch(List<K> ids);

    /**
     * 通过id进行查询
     * @param k id主键
     * @return v 包含了要查询的信息的vo对象
     * @throws Exception
     */
     V findById(K k);

    /**
     * 通过UID进行查询
     * @param uuid 表数据uuid
     * @return v 包含了要查询的信息的vo对象
     * @throws Exception
     */
     V findByUid(String uuid);

}
