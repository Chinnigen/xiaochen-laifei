package com.cry.domain.model.vo;

import com.cry.common.base.BaseVO;
import com.cry.common.validator.UpdateUsers;
import com.cry.common.validator.annotion.IntegerNotNull;
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
public class AuthUserVO extends BaseVO<AuthUserVO> {

    /**
     * 主键
     */
    @IntegerNotNull(groups = {UpdateUsers.class})
    private Long id;

    /**
     * 社交账户ID
     */
    private String socialId;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    private String passwordOld;

    private String verifyCode;

    /**
     * 角色主键 1 普通用户 2 admin
     */
    private Long roleId;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 注册时间
     */
    private LocalDateTime createTime;

    private String token;

    private List<String> roles;

    private String introduction;

    private Integer status;

    /**
     * 邮箱
     */
    private String email;

    private String accessKey;

    private String secretKey;

}
