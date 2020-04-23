package com.cry.common.exception;

import com.cry.common.base.constants.ResponseCode;

/**
 * @program: xiaochen-laofei
 * @description: 自定义业务异常
 * @author: Cry
 * @create: 2020-03-23 16:25
 **/
public class CommonBizException extends RuntimeException {

    private Integer code;

    public CommonBizException() {
    }

    public CommonBizException(ResponseCode responseCodeEnum) {
        //此处传入的是抛出异常后显示的信息提示
        super(responseCodeEnum.message());
        this.code = responseCodeEnum.code();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
