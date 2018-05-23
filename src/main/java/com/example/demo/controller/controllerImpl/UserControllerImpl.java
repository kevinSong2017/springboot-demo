package com.example.demo.controller.controllerImpl;

import com.example.demo.controller.UserController;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger=LoggerFactory.getLogger(UserControllerImpl.class);


    @RequestMapping(value = "login",method = RequestMethod.GET)
    @Override
    public Map<String ,Object> userLogin(String username, String password) {

        logger.info("info:username:"+username);
        logger.debug("debug:username:"+username);

        return userService.userLogin(username,password);

    }
}
