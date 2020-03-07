package com.cry.common.base;

import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author cry
 */
public interface IBaseDao<T> extends Mapper<T>, MySqlMapper<T> {

}
