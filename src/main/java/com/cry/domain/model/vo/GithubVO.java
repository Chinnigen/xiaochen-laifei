package com.cry.domain.model.vo;

import com.cry.common.base.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @description:
 * @author: byteblogs
 * @date: 2019/09/04 11:08
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class GithubVO extends BaseVO<GithubVO> {

    private String login;

    private String avatar_url;

    private String email;

    private String name;

    private String html_url;

}
