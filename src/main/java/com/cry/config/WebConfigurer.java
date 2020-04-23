package com.cry.config;

import com.cry.common.base.constants.Constants;
import com.cry.common.base.constants.ConstantsModels;
import com.cry.common.init.ConfigCache;
import com.cry.dao.IConfigDao;
import com.cry.domain.entity.Config;
import com.cry.domain.entity.SysLoginUser;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import javax.annotation.Resource;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Resource
    private IConfigDao configDao;

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {

        String defaultPath;
        try {
            //Config config = configDao.selectOneByExample(new LambdaQueryWrapper<Config>().eq(Config::getConfigKey, Constants.DEFAULT_PATH));
            Config config = configDao.selectOneByExample(Example.builder(SysLoginUser.class).where(Sqls.custom().andEqualTo("configKey", Constants.DEFAULT_PATH)).build());
            defaultPath = config.getConfigValue();
        } catch (Exception e) {
            defaultPath = ConstantsModels.getDefaultPath(ConfigCache.getConfig(Constants.DEFAULT_PATH));
        }
        registry.addResourceHandler("/files/**").addResourceLocations("file:///" + defaultPath);
    }
}