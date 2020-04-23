package com.cry.dao;

import com.cry.common.base.IBaseDao;
import com.cry.domain.entity.AuthUser;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author byteblogs
 * @since 2019-08-28
 */
@Repository
public interface IAuthUserDao extends IBaseDao<AuthUser> {

    String selectAvatar();
    AuthUser selectAdmin();

}
