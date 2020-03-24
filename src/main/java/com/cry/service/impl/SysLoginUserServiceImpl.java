package com.cry.service.impl;

import com.cry.common.base.impl.BaseServiceImpl;
import com.cry.common.constant.OperEnum;
import com.cry.common.constant.ResponseCode;
import com.cry.common.exception.CommonBizException;
import com.cry.dao.ISysLoginRecordDao;
import com.cry.dao.ISysLoginUserDao;
import com.cry.domain.entity.SysLoginRecord;
import com.cry.domain.entity.SysLoginUser;
import com.cry.service.ISysLoginUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import javax.annotation.Resource;
import java.util.List;


/**
 * @program: xiaochen-laofei
 * @description:
 * @author: Cry
 * @create: 2020-03-20 14:34
 **/

@Service("sysLoginService")
public class SysLoginUserServiceImpl extends BaseServiceImpl<SysLoginUser> implements ISysLoginUserService {

    @Resource
    private ISysLoginUserDao sysLoginUserDao;

    @Resource
    private ISysLoginRecordDao sysLoginRecordDao;

    @Override
    public List<SysLoginUser> getAllSysLoginUser() {
        return sysLoginUserDao.findAll();
    }

    @Override
    @Transactional
    public Boolean commonLogin(String userName, String password, String loginIP) {
        SysLoginUser user = new SysLoginUser();
        user.setUserName(userName);
        user = sysLoginUserDao.selectOne(user);
        if (user.getId() == null) {
            return false;
        }
        boolean loginResult = user.getPassword().equals(DigestUtils.sha1Hex(password));
        int count = sysLoginRecordDao.insertSelective(new SysLoginRecord(null, user.getId(), null, loginIP, null, null, OperEnum.WEB_MANAGER.operID()));
        return loginResult && count > 0;
    }

    @Override
    @Transactional
    public Boolean commonLogon(SysLoginUser user) {
        int userNameCount = sysLoginUserDao.selectCountByExample(Example.builder(SysLoginUser.class).where(Sqls.custom().andEqualTo("userName", user.getUserName())).build());
        if (userNameCount > 0) {
            throw new CommonBizException(ResponseCode.USER_HAS_EXISTED);
        }
        int count = sysLoginUserDao.insertSelective(user);
        return count > 0;
    }

    @Override
    public SysLoginUser getOneByUserName(String userName) {
        return sysLoginUserDao.selectOneByExample(Example.builder(SysLoginUser.class).where(Sqls.custom().andEqualTo("userName", userName)).build());
    }
}


