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
@Table(name = "hello_blog_posts")
public class Posts implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 封面图
     */
    private String thumbnail;

    /**
     * 评论数
     */
    private Integer comments;

    /**
     * 状态 1 草稿 2 发布
     */
    private Integer status;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 浏览次数
     */
    private Integer views;

    /**
     * 文章权重
     */
    private Integer weight;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    private Long authorId;

    /**
     * 是否打开评论
     */
    private Integer isComment;

    /**
     * 同步到byteblogs状态 (0 未同步 或者同步失败的状态 1同步已成功)
     */
    private Integer syncStatus;

    /**
     * 文章分类Id
     */
    private Integer categoryId;

    /**
     * 文章分类名称
     */
    private String categoryName;

}
