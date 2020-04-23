package com.cry.common.handler;

import com.cry.common.base.constants.ResponseCode;
import com.cry.common.exception.CommonBizException;
import com.cry.common.response.CommonApiResponse;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: xiaochen-laofei
 * @description: 全局异常处理
 * @author: Cry
 * @create: 2020-03-23 10:29
 **/

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * @Description: 参数非空异常处理
     * @Param: [e]
     * @return: com.cry.common.response.CommonApiResponse
     * @Author: Cry
     * @Date: 2020-03-23
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonApiResponse methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        e.printStackTrace();
        CommonApiResponse commonApiResponse = new CommonApiResponse();
        commonApiResponse.setCode(ResponseCode.PARAM_CUSTOM_ERROR.code());
        commonApiResponse.setMsg(e.getBindingResult().getFieldError().getDefaultMessage());
        return commonApiResponse;
    }

    /**
     * @Description: 参数格式异常处理
     * @Param: [e]
     * @return: com.cry.common.response.CommonApiResponse
     * @Author: Cry
     * @Date: 2020-03-23
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public CommonApiResponse httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
        e.printStackTrace();
        CommonApiResponse commonApiResponse = new CommonApiResponse();
        commonApiResponse.setCode(ResponseCode.PARAM_CUSTOM_ERROR.code());
        commonApiResponse.setMsg(e.getMessage());
        return commonApiResponse;
    }

    /**
     * @Description: 自定义业务异常处理
     * @Param: [e]
     * @return: com.cry.common.response.CommonApiResponse
     * @Author: Cry
     * @Date: 2020-03-23
     */
    @ExceptionHandler(CommonBizException.class)
    public CommonApiResponse commonBizExceptionHandler(CommonBizException e) {
        e.printStackTrace();
        CommonApiResponse commonApiResponse = new CommonApiResponse();
        commonApiResponse.setCode(e.getCode());
        commonApiResponse.setMsg(e.getMessage());
        return commonApiResponse;
    }

    /**
     * @Description: 自定义业务异常处理
     * @Param: [e]
     * @return: com.cry.common.response.CommonApiResponse
     * @Author: Cry
     * @Date: 2020-03-23
     */
    @ExceptionHandler(RuntimeException.class)
    public CommonApiResponse runtimeExceptionHandler(RuntimeException e) {
        e.printStackTrace();
        CommonApiResponse commonApiResponse = new CommonApiResponse();
        commonApiResponse.setCode(ResponseCode.SYSTEM_INNER_ERROR.code());
        commonApiResponse.setMsg(ResponseCode.SYSTEM_INNER_ERROR.message());
        return commonApiResponse;
    }
}
