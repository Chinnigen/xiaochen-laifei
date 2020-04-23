package com.cry.common.init.strategy;

import java.sql.Statement;

/**
 * @author zhangshuguang
 * @date 2019/12/25
 */
public interface TableInfoService {

    /**
     * 生成表的DDL语句
     */
    void builderTable(Statement stat);

}
