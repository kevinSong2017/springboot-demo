package com.demo.controller;

import com.demo.entity.User;

import java.util.Map;

public interface UserController {

    /**
     * 用户登陆接口
     * @param username
     * @param password
     * @return
     */
    Map<String,Object> userLogin(String username, String password);


    User getUser(String username, String password);

}
