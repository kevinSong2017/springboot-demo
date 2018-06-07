package com.demo.service;

import com.demo.entity.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {

    List<Role> getByMap(Map<String,Object> map);

    Role getById(Integer id);

    Role create(Role role);

    Role update(Role role);

    int delete(Integer id);

}
