package com.cry.domain.model.vo;

import com.cry.common.base.BaseVO;
import com.cry.common.validator.annotion.NotBlank;
import com.cry.common.validator.group.Insert;
import com.cry.common.validator.group.Update;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @date: 2019/9/1 20:52
 * @modified:
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class TagsVO extends BaseVO<TagsVO> {

    /**
     * 名称
     */
    @NotBlank(groups = {Insert.class, Update.class})
    private String name;

    /**
     * 文章总数
     */
    private Integer postsTotal;
}
