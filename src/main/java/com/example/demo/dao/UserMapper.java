package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

//import org.apache.ibatis.annotations.Select;

@Repository
@Mapper
public interface UserMapper {

    //@Select("select user_id ,user_name,user_password From user_info where user_name=#{username} and user_password=#{password}")
    Map<String ,Object> userLogin(@Param("username") String username, @Param("password") String password);


}
