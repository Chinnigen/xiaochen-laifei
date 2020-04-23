package com.cry.domain.model.vo;

import com.cry.common.base.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description:
 * @Author:byteblogs
 * @Date:2018/09/20 16:58
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class UserSessionVO extends BaseVO<UserSessionVO> {

    private Long id;

    private String socialId;

    private String name;

    private String avatar;

    private Integer gender;

    private Long roleId;

    private String token;

}
