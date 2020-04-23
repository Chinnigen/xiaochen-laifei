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
@Table(name = "hello_blog_auth_token")
public class AuthToken implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    /**
     * token
     */
    private String token;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    /**
     * 创建人
     */
    private Long userId;

}
