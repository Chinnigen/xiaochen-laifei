package com.cry.controller;

import com.cry.service.ICommonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class CommonController {

    @Resource(name = "commonService")
    private ICommonService commonService;

    @GetMapping("/allSysLoginRecord")
    public Object getAllSysLoginRecord() {
        return commonService.getAllSysLoginRecord();
    }
}
