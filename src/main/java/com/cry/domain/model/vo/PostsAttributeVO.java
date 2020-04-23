package com.cry.domain.model.vo;

import com.cry.common.base.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author byteblogs
 * @since 2019-08-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class PostsAttributeVO extends BaseVO<PostsAttributeVO> {

    private Long id;

    private String content;

}
