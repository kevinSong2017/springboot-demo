package com.demo.service;

import com.demo.entity.Role;
import com.demo.entity.User;
import com.demo.entity.UserRole;

import java.util.List;
import java.util.Map;

public interface UserService {

    Map<String,Object> userLogin(String username,String password);

    User getUser(String username, String password);

    List<User> getByMap(Map<String,Object> map);

    User getById(Integer id);

    User create(User user);

    User update(User user);

    int delete(Integer id);

    UserRole getUserRoleMess();

    List<Role> getRolePermission(int role_id);
}
