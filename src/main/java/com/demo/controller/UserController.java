package com.demo.controller;

import com.demo.entity.Role;
import com.demo.entity.SimpleUser;
import com.demo.entity.User;
import com.demo.entity.UserRole;

import java.util.List;
import java.util.Map;

public interface UserController {

    /**
     * 用户登陆接口
     * @param username
     * @param password
     * @return
     */
    Map<String,Object> userLogin(SimpleUser user);


    User getUser(String username, String password);


    UserRole getUserRoleMess();

    List<Role> getRolePermission(int role_id);


}
