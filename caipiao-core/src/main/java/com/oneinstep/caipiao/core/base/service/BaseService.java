package com.oneinstep.caipiao.core.base.service;

import java.util.List;

/**
 * 业务层父接口
 * @author henry.shaw(xiaoyao)
 * @param <K>
 * @param <V>
 */
public interface BaseService<K,V> {

    /**
     * 查询所有
     * @return
     */
    List<V> list();

    /**
     * 保存对象
     * @param v
     * @return
     */
    boolean save(V v);

    /**
     * 根据id查找内容
     * @param k
     * @return
     */
    V findById(K k);

    /**
     * 更新对象
     * @param v
     * @return
     */
    boolean update(V v);

    /**
     * 根据id删除对象
     * @param k
     * @return
     */
    boolean delete(K k);
}
