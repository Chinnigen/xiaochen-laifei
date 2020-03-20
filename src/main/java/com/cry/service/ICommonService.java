package com.cry.service;

import com.cry.common.base.IBaseService;
import com.cry.domain.entity.SysLoginRecord;

import java.util.List;

/**
 * @program: xiaochen-laofei
 * @description: service
 * @author: Cry
 * @create: 2020-03-07 11:18
 **/
public interface ICommonService extends IBaseService<SysLoginRecord> {

    List<SysLoginRecord> getAllSysLoginRecord();

}
