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
public class JueJinVO extends BaseVO<JueJinVO> {

    @ExtractBy("//*[@id='juejin']/div[2]/main/div/div[1]/article/h1/text()")
    private String title;

    @ExtractBy("//*[@class='article-content']")
    private List<String> content;

}
