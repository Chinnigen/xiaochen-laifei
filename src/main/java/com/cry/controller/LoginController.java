package com.cry.controller;

import com.cry.common.constant.ResponseCode;
import com.cry.common.response.CommonApiResponse;
import com.cry.domain.model.VO.LoginVO;
import com.cry.service.ISysLoginUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @program: xiaochen-laofei
 * @description:
 * @author: Cry
 * @create: 2020-03-20 15:04
 **/
@RestController
@RequestMapping("/login")
@Api(tags = "LoginApi")
public class LoginController {

    @Resource(name = "sysLoginService")
    private ISysLoginUserService sysLoginUserService;

    @GetMapping("/sysLoginUser/all")
    @ApiOperation("查询所有登录用户接口")
    public CommonApiResponse getAllLoginUser() {
        return CommonApiResponse.success(sysLoginUserService.getAllSysLoginUser());
    }

    @PostMapping("/commonlogin")
    @ApiOperation("Web登录通用接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "LoginVO", value = "登录对象", required = true, dataType = "LoginVO"),
    })
    public CommonApiResponse getSysLoginRecord(@RequestBody @Valid LoginVO vo) {
        Boolean flag = sysLoginUserService.commonLogin(vo);
        if (flag) {
            return CommonApiResponse.success();
        }
        return CommonApiResponse.error(ResponseCode.USER_LOGIN_ERROR);
    }
}
