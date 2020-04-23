package com.cry.service.impl;

import com.cry.common.base.impl.BaseServiceImpl;
import com.cry.dao.IAuthUserLogDao;
import com.cry.domain.entity.AuthUserLog;
import com.cry.service.IAuthUserLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: xiaochen-laofei
 * @description: 用户日志实现类
 * @author: Cry
 * @create: 2020-04-07 13:53
 **/
@Slf4j
@Service
public class AuthUserLogServiceImpl extends BaseServiceImpl<AuthUserLog> implements IAuthUserLogService {

    @Resource
    private IAuthUserLogDao authUserLogDao;

    @Override
    public Boolean saveLogs(AuthUserLog authUserLog) {
        log.debug("saveLogs AuthUserLog ,the authUserLog is {}", authUserLog.toString());
        return authUserLogDao.insert(authUserLog) > 0;
    }


    @Override
    public Boolean deleteLogs(Long id) {
        return authUserLogDao.deleteByPrimaryKey(id) > 0;
    }
}
