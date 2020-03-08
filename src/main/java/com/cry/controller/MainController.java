package com.cry.controller;

import com.cry.common.response.CommonApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: xiaochen-laofei
 * @description: 主控制器
 * @author: Cry
 * @create: 2020-03-06 16:32
 **/
@RestController
@RequestMapping("/main")
@Api(tags = "MainApi")
public class MainController {

    @GetMapping("/")
    @ApiOperation("示例Api")
    public CommonApiResponse sayHello() {
        return CommonApiResponse.success("老肥老肥 天下最肥！");
    }

    @GetMapping("/show")
    @ApiOperation("示例Api2")
    public CommonApiResponse show() {
        return CommonApiResponse.success("create by chenriyuan");
    }
}
