package com.cry.common.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @program: xiaochen-laofei
 * @description: 初始化配置
 * @author: Cry
 * @create: 2020-04-01 13:41
 **/
@Slf4j
@Component
public class ConfigApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(final ConfigurableApplicationContext configurableApplicationContext) {
        log.debug("==================初始化配置==================");
    }
}
