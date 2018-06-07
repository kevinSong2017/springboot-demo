package com.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import java.util.List;

public class User {
    private Integer id;
    private String cnname;
    @NotNull(message = "username不能为空")
    private String username;
    /**
     * 1、@JsonIgnoreProperties
     * 此注解是类注解，作用是json序列化时将java bean中的一些属性忽略掉，序列化和反序列化都受影响。
     * 写法将此标签加在model类的类名上 ，可以多个属性也可以单个属性
     *
     * 2、@JsonIgnore
     * 此注解用于属性或者方法上（最好是属性上），作用和上面的@JsonIgnoreProperties一样。
     * 生成json 时不生成password属性
     *
     * 3、@JsonFormat
     * 此注解用于属性或者方法上（最好是属性上），可以方便的把Date类型直接转化为我们想要的模式，比如@JsonFormat(pattern = “yyyy-MM-dd HH-mm-ss”)
     *
     * 4、@JsonSerialize
     * 此注解用于属性或者getter方法上，用于在序列化时嵌入我们自定义的代码，比如序列化一个double时在其后面限制两位小数点。
     *
     * 5、@JsonDeserialize
     * 此注解用于属性或者setter方法上，用于在反序列化时可以嵌入我们自定义的代码，类似于上面的@JsonSerialize
     *
     * 6、@Transient
     * @[email protected]�射,ORM框架将忽略该属性；
     * 如果一个属性并非数据库表的字段映射，就务必将其标示为@Transient，否则ORM框架默认其注解为@Basic；
     *
     */
    @JsonIgnore
    private String password;
    private String email;
    private String telephone;
    private String mobilePhone;
    private String wechatId;
    private String skill;
    private Integer departmentId;
    private Integer loginCount;

    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }
}
