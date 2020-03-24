package com.cry.config;

import com.cry.service.realm.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: xiaochen-laofei
 * @description: Shiro配置类
 * @author: Cry
 * @create: 2020-03-23 17:34
 **/
@Configuration
public class ShiroConfig {

    @Bean
    public Realm realm() {
        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return userRealm;
    }

    /**
     * 配置url
     * anon 任何人都能访问
     * authc 认证成功后才能访问
     */
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chain = new DefaultShiroFilterChainDefinition();
        Map<String, String> pathDefinitions = new HashMap<>();
        pathDefinitions.put("/login/commonlogin", "anon");
        pathDefinitions.put("/login/commonlogon", "anon");
        pathDefinitions.put("/swagger-ui.html", "anon");
        pathDefinitions.put("/webjars/**", "anon");
        pathDefinitions.put("/v2/**", "anon");
        pathDefinitions.put("/swagger-resources/**", "anon");
        pathDefinitions.put("/**", "authc");
        chain.addPathDefinitions(pathDefinitions);
        return chain;
    }


    /**
     * 密码验证
     *
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("SHA-1");
        credentialsMatcher.setHashIterations(5);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }
}