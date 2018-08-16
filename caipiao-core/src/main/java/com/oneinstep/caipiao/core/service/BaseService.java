package com.oneinstep.caipiao.core.service;

import org.apache.ibatis.session.SqlSessionException;
import org.hibernate.validator.internal.engine.messageinterpolation.InterpolationTerm;

import java.util.List;

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
    Integer save(V v);

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
    Integer update(V v);

    /**
     * 根据id删除对象
     * @param k
     * @return
     */
    Integer delete(K k);
}
