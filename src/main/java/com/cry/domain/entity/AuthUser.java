package com.cry.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "hello_blog_auth_user")
public class AuthUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    private Long id;

    private String socialId;

    /**
     * 别名
     */
    private String name;

    /**
     * 角色主键 1 普通用户 2 admin
     */
    private Long roleId;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 注册时间
     */
    private LocalDateTime createTime;

    /**
     * 密码
     */
    private String password;

    /**
     * 个人介绍
     */
    private String introduction;

    /**
     * 用户状态 0 正常 1 锁定
     */
    private Integer status;

    /**
     * 邮箱
     */
    private String email;

    private String accessKey;

    private String secretKey;
}
