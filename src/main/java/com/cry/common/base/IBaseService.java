package com.cry.common.base;

import java.util.List;

/**
 * @program: xiaochen-laofei
 * @description: 通用service
 * @author: Cry
 * @create: 2020-03-07 12:33
 **/
public interface IBaseService<T> {

    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);
}
