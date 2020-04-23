package com.cry.common.sync;

import com.cry.domain.entity.AuthUserLog;
import com.cry.service.IAuthUserLogService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class LogSyncTask {

    @Resource
    private IAuthUserLogService sysLogServiceImpl;

    @Async(value = "asyncExecutor")
    public void addLog(AuthUserLog sysLog) {
        sysLogServiceImpl.saveLogs(sysLog);
    }
}
