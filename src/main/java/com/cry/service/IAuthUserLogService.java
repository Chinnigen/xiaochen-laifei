package com.cry.service;

import com.cry.common.base.IBaseService;
import com.cry.domain.entity.AuthUserLog;


/**
 * @program: xiaochen-laofei
 * @description: 用户日志记录服务
 * @author: Cry
 * @create: 2020-04-07 13:44
 **/
public interface IAuthUserLogService extends IBaseService<AuthUserLog> {

    Boolean saveLogs(AuthUserLog authUserLog);

    /**
     * 分页查询用户行为日志记录表
     */
    //Page<AuthUserLog> getLogsList(AuthUserLog authUserLog);

    Boolean deleteLogs(Long id);
}
