package com.cry.service.realm;

import com.cry.common.base.constants.ResponseCode;
import com.cry.common.exception.CommonBizException;
import com.cry.domain.entity.SysLoginUser;
import com.cry.service.ISysLoginUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashSet;

/**
 * @program: xiaochen-laofei
 * @description: 自定义Realm
 * @author: Cry
 * @create: 2020-03-23 17:36
 **/
public class UserRealm extends AuthorizingRealm {

    @Resource(name = "sysLoginService")
    private ISysLoginUserService sysLoginUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        if (principalCollection == null) {
            throw new CommonBizException(ResponseCode.PARAM_IS_BLANK);
        }
        SysLoginUser user = (SysLoginUser) getAvailablePrincipal(principalCollection);
        if (ObjectUtils.isEmpty(user)) {
            throw new CommonBizException(ResponseCode.USER_NOT_EXIST);
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(new HashSet<>() {{
            add("public");
        }});

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        if (StringUtils.isEmpty(username)) {
            throw new CommonBizException(ResponseCode.PARAM_IS_BLANK);
        }
        SysLoginUser user = sysLoginUserService.getOneByUserName(username);
        if (ObjectUtils.isEmpty(user)) {
            throw new CommonBizException(ResponseCode.USER_NOT_EXIST);
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
    }
}