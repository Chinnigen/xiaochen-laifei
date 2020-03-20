package com.cry.service;

import com.cry.common.base.IBaseService;
import com.cry.domain.entity.SysPermission;

import java.util.List;

/**
 * @program: xiaochen-laofei
 * @description: 权限服务
 * @author: Cry
 * @create: 2020-03-20 14:32
 **/
public interface ISysPermissionService extends IBaseService<SysPermission> {

    List<SysPermission> getAllSysPermission();

}
