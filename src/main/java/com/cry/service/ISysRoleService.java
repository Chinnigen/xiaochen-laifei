package com.cry.service;

import com.cry.common.base.IBaseService;
import com.cry.domain.entity.SysRole;

import java.util.List;

/**
 * @program: xiaochen-laofei
 * @description: 角色服务
 * @author: Cry
 * @create: 2020-03-20 14:32
 **/
public interface ISysRoleService extends IBaseService<SysRole> {

    List<SysRole> getAllSysRole();
}
