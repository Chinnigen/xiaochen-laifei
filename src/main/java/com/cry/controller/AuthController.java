package com.cry.controller;

import com.cry.common.response.CommonApiResponse;
import com.cry.service.ISysPermissionService;
import com.cry.service.ISysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: xiaochen-laofei
 * @description:
 * @author: Cry
 * @create: 2020-03-20 15:05
 **/
@RestController
@RequestMapping("/auth")
@Api(tags = "AuthApi")
public class AuthController {

    @Resource(name = "sysRoleService")
    private ISysRoleService sysRoleService;

    @Resource(name = "sysPermissionService")
    private ISysPermissionService sysPermissionService;

    @GetMapping("/sysRole/all")
    @ApiOperation("查询所有角色接口")
    public CommonApiResponse getAllSysRole() {
        return CommonApiResponse.success(sysRoleService.getAllSysRole());
    }

    @GetMapping("/sysPermission/all")
    @ApiOperation("查询所有权限接口")
    public CommonApiResponse getAllSysPermission() {
        return CommonApiResponse.success(sysPermissionService.getAllSysPermission());
    }
}
