package com.example.demo.controller;

import java.util.Map;

public interface UserController {

    /**
     * 用户登陆接口
     * @param username
     * @param password
     * @return
     */
    Map<String,Object> userLogin(String username, String password);

}
