package com.demo.service.impl;

import com.demo.dao.UserDao;
import com.demo.dao.UserMapper;
import com.demo.entity.Role;
import com.demo.entity.User;
import com.demo.entity.UserRole;
import com.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDao userDao;

    private static Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Map<String, Object> userLogin(String username, String password) {

        Map<String ,Object> map=new HashMap<String, Object>();
        map.put("username",username);
        map.put("password",password);
        return userMapper.userLogin(username,password);

    }

    @Override
    public User getUser(String username, String password) {

        logger.info(username+"--"+password);
        return userMapper.getUser(username,password);
    }

    /**
     * ***************************************************
     */

    @Override
    public List<User> getByMap(Map<String, Object> map) {
        return userDao.getByMap(map);
    }

    @Override
    public User getById(Integer id) {
        return userDao.getById(id);
    }

    @Override
    public User create(User user) {
        userDao.create(user);
        return user;
    }

    @Override
    public User update(User user) {
        userDao.update(user);
        return user;
    }

    @Override
    public int delete(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public UserRole getUserRoleMess() {
        return userMapper.getUserRoleMess();
    }

    @Override
    public List<Role> getRolePermission(int role_id) {
        return userMapper.getRolePermission(role_id);
    }


    @Override
    public void insertIntoUser(String a) {
        int i = userMapper.insertIntoUser(a);
        logger.info("插入是否成功："+i);
    }
}
