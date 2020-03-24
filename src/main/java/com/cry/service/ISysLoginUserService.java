package com.cry.service;

import com.cry.common.base.IBaseService;
import com.cry.domain.entity.SysLoginUser;

import java.util.List;

/**
 * @program: xiaochen-laofei
 * @description: 登录服务
 * @author: Cry
 * @create: 2020-03-20 14:31
 **/
public interface ISysLoginUserService extends IBaseService<SysLoginUser> {

    List<SysLoginUser> getAllSysLoginUser();

    Boolean commonLogin(String userName, String password, String loginIP);

    Boolean commonLogon(SysLoginUser user);

    SysLoginUser getOneByUserName(String userName);

}
