package com.cry.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "hello_blog_auth_user_social")
public class AuthUserSocial implements Serializable {

    private static final long serialVersionUID = 1L;

    // columns START

    @Id
    private Long id;

    /**
     * qq、csdn、wechat、weibo、email等
     */
    private String code;

    /**
     * 内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 展示类型( 1、图片，2、文本，3、链接)
     */
    @Column(name = "show_type")
    private Integer showType;

    /**
     * 备注
     */
    private String remark;

    /**
     * 图标
     */
    private String icon;

    /**
     * 是否启用
     */
    @Column(name = "is_enabled")
    private Integer isEnabled;

    /**
     * 是否主页社交信息
     */
    @Column(name = "is_home")
    private Integer isHome;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;
    // columns END
}