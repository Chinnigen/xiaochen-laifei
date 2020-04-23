package com.cry.domain.model.vo;

import com.cry.common.base.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import us.codecraft.webmagic.model.annotation.ExtractBy;

import java.util.List;

/**
 * @author: zsg
 * @description:
 * @date: 2019/8/3 13:15
 * @modified:
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class CSDNVO extends BaseVO<CSDNVO> {

    @ExtractBy("//*[@id=\"mainBox\"]/main/div[1]/div/div/div[1]/h1/text()")
    private String title;

    @ExtractBy("//*[@id='content_views']")
    private List<String> content;

}
