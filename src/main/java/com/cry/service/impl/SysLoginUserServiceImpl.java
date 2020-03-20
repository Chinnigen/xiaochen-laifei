package com.cry.service.impl;

import com.cry.common.base.impl.BaseServiceImpl;
import com.cry.dao.ISysLoginUserDao;
import com.cry.domain.entity.SysLoginUser;
import com.cry.domain.model.VO.LoginVO;
import com.cry.service.ISysLoginUserService;
import org.springframework.stereotype.Service;

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

    @Resource(name = "ISysLoginUserDao")
    private ISysLoginUserDao sysLoginUserDao;

    @Override
    public List<SysLoginUser> getAllSysLoginUser() {
        return sysLoginUserDao.findAll();
    }

    @Override
    public Boolean commonLogin(LoginVO vo) {
        SysLoginUser user = new SysLoginUser();
        user.setUserName(vo.getUserName());
        user = sysLoginUserDao.selectOne(user);
        if(user.getId() == null){
            return false;
        }
        return true;
    }
}


