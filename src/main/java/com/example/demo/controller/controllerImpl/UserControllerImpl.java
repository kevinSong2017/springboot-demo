package com.example.demo.controller.controllerImpl;

import com.example.demo.controller.UserController;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;


@RestController
@RequestMapping("uc")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;



    @RequestMapping(value = "login",method = RequestMethod.GET)
    @Override
    public Map<String ,Object> userLogin(String username, String password) {

        return userService.userLogin(username,password);

    }
}
