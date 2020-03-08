package com.cry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: xiaochen-laofei
 * @description: Swagger配置类
 * @author: Cry
 * @create: 2020-03-08 15:11
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //生成api文档扫描路径
                .apis(RequestHandlerSelectors.basePackage("com.cry.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("xiaochen-laofei RestfulWebApi")
                //作者
                .contact(new Contact("Chinnigen", "https://github.com/Chinnigen/xiaochen-laofei", "chenriyuan@gmail.com"))
                //版本号
                .version("1.0")
                //描述
                .description("Base Java 11")
                .build();
    }
}
