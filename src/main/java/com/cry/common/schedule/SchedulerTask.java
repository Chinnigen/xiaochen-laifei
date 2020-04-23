package com.cry.common.schedule;

import com.cry.dao.IAuthTokenDao;
import com.cry.domain.entity.AuthToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.time.LocalDateTime;

/**
 * @Author:byteblogs
 * @Date:2018/09/27 12:52
 */
@Component
@Slf4j
public class SchedulerTask {

    @Autowired
    private IAuthTokenDao authTokenDao;

    @Scheduled(cron = "0 0/1 * * * ?")
    private void scanToken() {
        log.debug(" {} 扫描过期Token", LocalDateTime.now());
        //authTokenDao.delete(new LambdaQueryWrapper<AuthToken>().le(AuthToken::getExpireTime, LocalDateTime.now()));
        authTokenDao.deleteByExample(Example.builder(AuthToken.class).where(Sqls.custom().andLessThanOrEqualTo("expireTime", LocalDateTime.now())).build());
    }
}
