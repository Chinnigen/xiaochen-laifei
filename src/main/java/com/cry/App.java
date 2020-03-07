package com.cry;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @program: xiaochen-laofei
 * @description: 启动类
 * @author: Cry
 * @create: 2020-03-06 16:32
 **/
@SpringBootApplication
@EnableCaching
@MapperScan("com.cry.dao")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
