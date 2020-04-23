package com.cry.dao;

import com.cry.common.base.IBaseDao;
import com.cry.domain.entity.AuthUserSocial;
import com.cry.domain.model.vo.AuthUserSocialVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 用户表社交信息表:数据层
 *
 * @author generator
 * @date 2020-01-01 17:34:27
 * @since 1.0
 */
@Repository
public interface IAuthUserSocialDao extends IBaseDao<AuthUserSocial> {

    List<AuthUserSocialVO> selectSocialList(@Param("page") Page<AuthUserSocial> page, @Param("condition") AuthUserSocialVO authUserSocialVO);

}
