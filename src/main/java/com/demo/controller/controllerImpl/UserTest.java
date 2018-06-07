package com.demo.controller.controllerImpl;

import com.demo.controller.UserController;
import com.demo.entity.User;

import java.util.Map;

/**
 * 接口可以继承类
 */
public interface UserTest extends UserController {

    @Override
    User getUser(String username, String password);


    @Override
    Map<String, Object> userLogin(String username, String password);




}
