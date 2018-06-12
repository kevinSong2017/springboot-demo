package com.demo.controller.controllerImpl;

import com.demo.controller.HelloController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 项目跳转控制
 */
@Controller
public class HelloControllerImpl implements HelloController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String hello(){
        System.out.println("访问成功");
        return "index";
    }

}
