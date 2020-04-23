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
@Table(name = "hello_blog_posts_tags")
public class PostsTags implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    /**
     * 名称
     */
    private Long tagsId;

    /**
     * 文章主键
     */
    private Long postsId;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
