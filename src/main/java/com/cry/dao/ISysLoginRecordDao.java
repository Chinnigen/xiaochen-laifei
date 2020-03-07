package com.cry.dao;

import com.cry.common.base.IBaseDao;
import com.cry.domain.entity.SysLoginRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: xiaochen-laofei
 * @description: 访问记录Dao
 * @author: Cry
 * @create: 2020-03-07 10:34
 **/
public interface ISysLoginRecordDao extends IBaseDao<SysLoginRecord> {

    List<SysLoginRecord> findAll();
}
