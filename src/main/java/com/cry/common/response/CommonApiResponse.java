package com.cry.common.response;

import com.cry.common.base.constants.ResponseCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: xiaochen-laofei
 * @description: Api通用返回类
 * @author: Cry
 * @create: 2020-03-08 15:31
 **/
public class CommonApiResponse {
    private Integer code;

    private String msg;

    private Object data;

    public CommonApiResponse() {
    }

    public CommonApiResponse(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public CommonApiResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static CommonApiResponse success() {
        CommonApiResponse result = new CommonApiResponse();
        result.setResultCode(ResponseCode.SUCCESS);
        return result;
    }

    public static CommonApiResponse success(Object data) {
        CommonApiResponse result = new CommonApiResponse();
        result.setResultCode(ResponseCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static CommonApiResponse error(ResponseCode resultCode) {
        CommonApiResponse result = new CommonApiResponse();
        result.setResultCode(resultCode);
        return result;
    }

    public static CommonApiResponse error(ResponseCode resultCode, Object data) {
        CommonApiResponse result = new CommonApiResponse();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

    public void setResultCode(ResponseCode code) {
        this.code = code.code();
        this.msg = code.message();
    }


    public Map<String, Object> simple() {
        Map<String, Object> simple = new HashMap<String, Object>();
        this.data = simple;

        return simple;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
