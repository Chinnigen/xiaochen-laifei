package com.cry.controller;

import com.cry.common.constant.ResponseCode;
import com.cry.common.response.CommonApiResponse;
import com.cry.domain.entity.SysLoginUser;
import com.cry.domain.model.vo.LoginVO;
import com.cry.domain.model.vo.RegisterVO;
import com.cry.service.ISysLoginUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
    public CommonApiResponse commonLogin(@RequestBody @Valid LoginVO vo) {
        return sysLoginUserService.commonLogin(vo.getUserName(), vo.getPassword(), vo.getLoginIP()) ? CommonApiResponse.success() : CommonApiResponse.error(ResponseCode.USER_LOGIN_ERROR);
    }

    @PostMapping("/commonlogon")
    @ApiOperation("Web注册通用接口")
    public CommonApiResponse commonRegister(@RequestBody @Valid RegisterVO vo) {
        SysLoginUser user = vo.toSysLoginUser();
        return sysLoginUserService.commonLogon(user) ? CommonApiResponse.success() : CommonApiResponse.error(ResponseCode.USER_REGISTER_ERROR);
    }
}
