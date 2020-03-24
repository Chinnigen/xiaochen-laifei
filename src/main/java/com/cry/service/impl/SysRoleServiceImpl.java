package com.cry.service.impl;

import com.cry.common.base.impl.BaseServiceImpl;
import com.cry.dao.ISysRoleDao;
import com.cry.domain.entity.SysRole;
import com.cry.service.ISysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: xiaochen-laofei
 * @description:
 * @author: Cry
 * @create: 2020-03-20 14:35
 **/
@Service("sysRoleService")
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements ISysRoleService {

    @Resource
    private ISysRoleDao sysRoleDao;

    @Override
    public List<SysRole> getAllSysRole() {
        return sysRoleDao.findAll();
    }
}
