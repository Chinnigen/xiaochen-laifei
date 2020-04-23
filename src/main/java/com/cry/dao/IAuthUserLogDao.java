package com.cry.dao;

import com.cry.common.base.IBaseDao;
import com.cry.domain.entity.AuthUserLog;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 用户行为日志记录表:数据层
 */
public interface IAuthUserLogDao extends IBaseDao<AuthUserLog> {

    List<AuthUserLog> selectLogsList(@Param("page") Page<AuthUserLog> page, @Param("condition") AuthUserLog condition);

    /**
     * 查询文章访问统计
     *
     * @param startTime
     * @param endTime
     * @return
     */
    List<AuthUserLog> selectPostsListStatistics(@Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime, @Param("type") String type);

    /**
     * 查询文章的排名
     *
     * @param startTime
     * @param endTime
     * @return
     */
    List<AuthUserLog> selectPostsRanking(Page page, @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);
}
