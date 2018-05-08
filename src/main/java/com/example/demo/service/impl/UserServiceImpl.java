package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public Map<String, Object> userLogin(String username, String password) {

        Map<String ,Object> map=new HashMap<String, Object>();
        map.put("username",username);
        map.put("password",password);
        return userMapper.userLogin(username,password);

    }
}
