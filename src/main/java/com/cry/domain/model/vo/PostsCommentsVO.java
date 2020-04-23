package com.cry.domain.model.vo;

import com.cry.common.base.BaseVO;
import com.cry.common.validator.InsertPostsComments;
import com.cry.common.validator.QueryPostsComments;
import com.cry.common.validator.annotion.NotBlank;
import com.cry.common.validator.annotion.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 评论表
 * </p>
 * @author byteblogs
 * @since 2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class PostsCommentsVO extends BaseVO<PostsCommentsVO> {

    private Long authorId;

    @NotBlank(groups = {InsertPostsComments.class})
    private String content;

    private Long parentId;

    private Integer status;

    @NotNull(groups = {InsertPostsComments.class, QueryPostsComments.class})
    private Long postsId;

    private String treePath;

    private String authorName;

    private String authorAvatar;

    private String parentUserName;

    private LocalDateTime createTime;

}
