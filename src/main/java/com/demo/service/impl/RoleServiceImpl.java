package com.demo.service.impl;

import com.demo.dao.RoleDao;
import com.demo.entity.Role;
import com.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao  roleDao;


    @Override
    public List<Role> getByMap(Map<String, Object> map) {
        return roleDao.getByMap(map);
    }

    @Override
    public Role getById(Integer id) {
        return roleDao.getById(id);
    }

    @Override
    public Role create(Role role) {
        roleDao.create(role);
        return role;
    }

    @Override
    public Role update(Role role) {
        roleDao.update(role);
        return role;
    }

    @Override
    public int delete(Integer id) {
        return roleDao.delete(id);
    }
}
