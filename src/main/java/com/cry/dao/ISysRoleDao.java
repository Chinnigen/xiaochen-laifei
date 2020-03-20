package com.cry.dao;

import com.cry.common.base.IBaseDao;
import com.cry.domain.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: xiaochen-laofei
 * @description:
 * @author: Cry
 * @create: 2020-03-20 11:44
 **/
@Repository
public interface ISysRoleDao extends IBaseDao<SysRole> {

    List<SysRole> findAll();
}
