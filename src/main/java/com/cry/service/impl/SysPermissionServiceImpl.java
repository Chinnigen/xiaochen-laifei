package com.cry.service.impl;

import com.cry.common.base.impl.BaseServiceImpl;
import com.cry.dao.ISysPermissionDao;
import com.cry.domain.entity.SysPermission;
import com.cry.service.ISysPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: xiaochen-laofei
 * @description:
 * @author: Cry
 * @create: 2020-03-20 14:35
 **/
@Service("sysPermissionService")
public class SysPermissionServiceImpl extends BaseServiceImpl<SysPermission> implements ISysPermissionService {

    @Resource
    private ISysPermissionDao sysPermissionDao;

    @Override
    public List<SysPermission> getAllSysPermission() {
        return sysPermissionDao.findAll();
    }
}
