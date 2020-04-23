package com.cry.domain.model.vo;

import com.cry.common.base.BaseVO;
import com.cry.common.validator.InsertSocial;
import com.cry.common.validator.UpdateSocial;
import com.cry.common.validator.annotion.IntegerNotNull;
import com.cry.common.validator.annotion.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import java.time.LocalDateTime;

/**
 * 用户表社交信息表 实体类
 *
 * @author nosum
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AuthUserSocialVO extends BaseVO<AuthUserSocialVO> {
    // columns START
    @IntegerNotNull(groups = {UpdateSocial.class})
    private Long id;

    /**
     * qq、csdn、wechat、weibo、email等
     */
    @NotBlank(groups = {InsertSocial.class})
    private String code;
    /**
     * 内容
     */
    @Column(name = "content")
    private String content;

    /**
     * 展示类型( 1、显示二维码，2、显示账号，3、跳转链接)
     */
    @Column(name = "show_type")
    private Integer showType;

    /**
     * 备注
     */
    private String remark;

    private String icon;

    /**
     * 是否删除
     */
    @Column(name = "is_enabled")
    private Integer isEnabled;

    /**
     * 是否主页社交信息
     */
    @Column(name = "is_home")
    private Integer isHome;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;
    // columns END
}