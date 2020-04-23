package com.cry.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @program: xiaochen-laofei
 * @description:
 * @author: Cry
 * @create: 2020-03-07 10:25
 **/
@Data
@Accessors(chain = true)
@Table(name = "hello_blog_auth_user_log")
public class AuthUserLog implements Serializable {

    @Id
    private Long id;

    /**
     * 记录用户id(游客取系统id：-1)
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 请求的url
     */
    private String url;

    /**
     * 需要记录的参数
     */
    private String parameter;

    /**
     * 来自于哪个设备 eg 手机 型号 电脑浏览器
     */
    private String device;

    /**
     * 描述
     */
    private String description;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 执行时间
     */
    @Column(name = "run_time")
    private Long runTime;

    /**
     * 日志类型
     */
    private String code;

    /**
     * 浏览器名称
     */
    @Column(name = "browser_name")
    private String browserName;
    /**
     * 浏览器版本号
     */
    @Column(name = "browser_version")
    private String browserVersion;
}