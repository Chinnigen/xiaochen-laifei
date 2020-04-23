package com.cry.domain.model.vo;

import com.cry.common.base.BaseVO;
import com.cry.common.validator.annotion.NotBlank;
import com.cry.common.validator.group.Insert;
import com.cry.common.validator.group.Update;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author byteblogs
 * @since 2019-08-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class CategoryVO extends BaseVO<CategoryVO> {

    /**
     * 名称
     */
    @NotBlank(groups = {Insert.class, Update.class})
    private String name;

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

    private List<TagsVO> tagsList;

    private Integer total;
}
