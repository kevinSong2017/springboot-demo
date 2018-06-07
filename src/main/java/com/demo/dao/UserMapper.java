package com.demo.dao;

import com.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

//import org.apache.ibatis.annotations.Select;

@Repository
@Mapper
public interface UserMapper {

    Map<String ,Object> userLogin(@Param("username") String username, @Param("password") String password);

    User getUser(@Param("username") String username, @Param("password")String password);

    User getByUserName(String primaryPrincipal);
}
