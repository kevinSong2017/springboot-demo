package com.demo.entity;

import java.util.List;

public class Role {
    private Integer id;
    private String name;
    private Integer roleLevel;
    private String description;

    /**
     * 一个role 对应多个权限
     */
    private List<Permission> permissions;

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getRoleLevel() {
        return roleLevel;
    }
    public void setRoleLevel(Integer roleLevel) {
        this.roleLevel = roleLevel;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}