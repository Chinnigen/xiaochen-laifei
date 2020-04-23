package com.cry.common.init;

import com.byteblogs.helloblog.bean.BeanTool;
import com.byteblogs.helloblog.bean.SystemPropertyBean;
import com.cry.common.enums.RoleEnum;
import com.cry.dao.IAuthUserDao;
import com.cry.dao.IConfigDao;
import com.cry.domain.entity.AuthUser;
import com.cry.domain.entity.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.util.List;

/**
 * @author: byteblogs
 * @date: 2019/09/03 12:09
 */
@Slf4j
@Component
@DependsOn({"druidDataSource"})
public class InitSystemConfig implements ApplicationListener<ApplicationContextEvent>, Ordered {

    private IConfigDao configDao;

    private IAuthUserDao authUserDao;

    @Autowired
    public InitSystemConfig(IConfigDao configDao, IAuthUserDao authUserDao) {
        this.configDao = configDao;
        this.authUserDao = authUserDao;
    }

    public void init() {
        List<Config> configList = configDao.selectAll();
        configList.forEach(config -> {
            log.debug("config_key: {}, config_vlaue: {}", config.getConfigKey(), config.getConfigValue());
            ConfigCache.putConfig(config.getConfigKey(), config.getConfigValue());
        });

        //List<AuthUser> authUsers = authUserDao.selectList(new LambdaQueryWrapper<AuthUser>().eq(AuthUser::getRoleId, RoleEnum.ADMIN.getRoleId()));
        List<AuthUser> authUsers = authUserDao.selectByExample(Example.builder(AuthUser.class).where(Sqls.custom().andEqualTo("roleId", RoleEnum.ADMIN.getRoleId())).build());

        if (!CollectionUtils.isEmpty(authUsers)) {
            SystemPropertyBean systemPropertyBean = BeanTool.getBean(SystemPropertyBean.class);
            systemPropertyBean.setAccessKey(authUsers.get(0).getAccessKey());
            systemPropertyBean.setSecretKey(authUsers.get(0).getSecretKey());
        }
    }

    @Override
    public void onApplicationEvent(ApplicationContextEvent applicationContextEvent) {
        init();
    }

    @Override
    public int getOrder() {
        return 1;
    }
}