package com.demo.service.impl;

import com.demo.dao.PermissionDao;
import com.demo.entity.Permission;
import com.demo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;


    @Override
    public List<Permission> getByMap(Map<String, Object> map) {
        return permissionDao.getByMap(map);
    }

    @Override
    public Permission getById(Integer id) {
        return permissionDao.getById(id);
    }

    @Override
    public Permission create(Permission permission) {
        permissionDao.create(permission);
        return permission;
    }

    @Override
    public Permission update(Permission permission) {
        permissionDao.update(permission);
        return permission;
    }

    @Override
    public int delete(Integer id) {
        return permissionDao.delete(id);
    }
}
