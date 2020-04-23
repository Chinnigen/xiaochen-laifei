package com.cry.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @program: xiaochen-laofei
 * @description:
 * @author: Cry
 * @create: 2020-03-07 10:25
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "hello_blog_posts_attribute")
public class PostsAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String content;

    private Long postsId;

}
