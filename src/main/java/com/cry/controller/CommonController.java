package com.cry.controller;

import com.cry.common.response.CommonApiResponse;
import com.cry.service.ICommonService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: xiaochen-laofei
 * @description: 基础控制类
 * @author: Cry
 * @create: 2020-03-07 12:45
 **/
@RestController
@RequestMapping("/common")
@Api(tags = "CommonApi")
public class CommonController {

    @Resource(name = "commonService")
    private ICommonService commonService;

    @GetMapping("/sysLoginRecord/all")
    @ApiOperation("查询所有访问记录接口")
    public CommonApiResponse getAllSysLoginRecord() {
        return CommonApiResponse.success(commonService.getAllSysLoginRecord());
    }

    @GetMapping("/sysLoginRecord/pk")
    @ApiOperation("同个id查询单个访问记录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "String"),
    })
    public CommonApiResponse getSysLoginRecord(@RequestParam(value = "id") String id) {
        return CommonApiResponse.success(commonService.selectByKey(id));
    }
}
