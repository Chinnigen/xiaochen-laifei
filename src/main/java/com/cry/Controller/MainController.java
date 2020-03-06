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

    /**
     * @Description: Hello方法
     * @Param: []
     * @return: java.lang.String
     * @Author: Cry
     * @Date: 2020-03-06
     */
    @GetMapping("/")
    public String sayHello() {
        return "老肥老肥 天下最肥！";
    }

    /**
     * @Description: Hello方法
     * @Param: []
     * @return: java.lang.String
     * @Author: Cry
     * @Date: 2020-03-06
     */
    @GetMapping("/show")
    public String show() {
        return "create by chenriyuan";
    }
}
