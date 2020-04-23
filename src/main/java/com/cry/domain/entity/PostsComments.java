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
@Table(name = "hello_blog_posts_comments")
public class PostsComments implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private Long authorId;

    private String content;

    private Long parentId;

    private Integer status;

    private Long postsId;

    /**
     * 层级结构
     */
    private String treePath;

    private LocalDateTime createTime;

}
