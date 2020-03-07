package com.cry.service.impl;

import com.cry.common.base.impl.BaseServiceImpl;
import com.cry.dao.ISysLoginRecordDao;
import com.cry.domain.entity.SysLoginRecord;
import com.cry.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: xiaochen-laofei
 * @description: CommonService实现类
 * @author: Cry
 * @create: 2020-03-07 12:35
 **/
@Service("commonService")
public class CommonServiceImpl extends BaseServiceImpl<SysLoginRecord> implements ICommonService {

    @Resource
    private ISysLoginRecordDao sysLoginRecordDao;

    @Override
    public List<SysLoginRecord> getAllSysLoginRecord() {
        return sysLoginRecordDao.findAll();
    }
}
