package com.cry.common.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.cry.common.annotation.OperateLog;
import com.cry.common.base.constants.Constants;
import com.cry.common.enums.OperateEnum;
import com.cry.common.sync.LogSyncTask;
import com.cry.common.utils.HttpContextUtils;
import com.cry.common.utils.JsonUtil;
import com.cry.domain.entity.AuthUser;
import com.cry.domain.entity.AuthUserLog;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Enumeration;
import java.util.Map;
import java.util.Optional;

@Aspect
@Component
public class LogAspect {

    @Resource
    private LogSyncTask logSyncTask;

    @Pointcut(value = "@annotation(com.cry.common.annotation.OperateLog)")
    public void logsPointCut() {
    }// 配置切点

    /**
     * 配置环绕通知
     */
    @Around("logsPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis(); // 开始时间
        Object result = point.proceed(); // 执行方法
        long time = System.currentTimeMillis() - beginTime;// 结束时间
        this.saveLog(point, time);
        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        AuthUserLog authUserLog = new AuthUserLog();
        OperateLog operateLog = method.getAnnotation(OperateLog.class);
        if (operateLog != null) {
            authUserLog.setDescription(operateLog.module());//  获取注解上的描述
            authUserLog.setCode(operateLog.code().getCode());// 获取主街上定义的类型
        }

        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        JSONObject parameter = new JSONObject();// 保存参数
        if (authUserLog.getCode().equals(OperateEnum.GET_POSTS_DETAIL.getCode())) {
            Map<String, String> pathVariables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
            for (Map.Entry<String, String> map : pathVariables.entrySet()) {
                parameter.put(map.getKey(), map.getValue());
            }
        } else {
            // 请求的参数
            Enumeration<String> enums = request.getParameterNames();
            while (enums.hasMoreElements()) {
                String paramName = enums.nextElement();
                String paramValue = request.getParameter(String.valueOf(paramName));
                parameter.put(paramName, paramValue);
            }
        }

        authUserLog.setParameter(parameter.toJSONString());
        authUserLog.setIp(HttpContextUtils.getIpAddr(request));
        authUserLog.setUrl(request.getRequestURI());
        authUserLog.setDevice(HttpContextUtils.getOsName(request));
        authUserLog.setBrowserName(HttpContextUtils.getBrowserName(request));
        authUserLog.setBrowserVersion(HttpContextUtils.getBrowserVersion(request));

        // 取得用户信息
        String token = Optional.ofNullable(request.getHeader(Constants.AUTHENTICATION)).orElse(null);
        if (!StringUtils.isBlank(token)) {
            AuthUser authUser = JsonUtil.parseObject(JWT.decode(token).getAudience().get(0), AuthUser.class);
            authUserLog.setUserId(authUser.getId().toString());
        } else {
            authUserLog.setUserId(Constants.DEFAULT_USER_ID);
        }
        // 统计时间
        authUserLog.setRunTime(time);
        authUserLog.setCreateTime(LocalDateTime.now());
        // 保存系统日志
        logSyncTask.addLog(authUserLog);
    }
}