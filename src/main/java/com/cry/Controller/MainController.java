package com.cry.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: xiaochen-laofei
 * @description: 主控制器
 * @author: Cry
 * @create: 2020-03-06 16:32
 **/
@RestController
public class MainController {

    @GetMapping("/")
    public String sayHello() {
        return "老肥老肥 天下最肥！";
    }
}
