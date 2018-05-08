package com.example.demo.controller.controllerImpl;

import com.example.demo.controller.HelloController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllerImpl implements HelloController {

    @RequestMapping(value = "hello",method = RequestMethod.GET,name = "helloService")
    public  @ResponseBody String hello(){

        System.out.println("访问成功");

        return "hello";

    }

}
