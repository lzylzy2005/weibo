package com.example.weiboserver.mapper;

import com.example.weiboserver.bean.User;
import org.apache.ibatis.annotations.Select;
import java.util.List;

//public interface UserMapper {
//    @Select("select username, password from user")
//    List<User> findAllUser();
//}

import org.apache.ibatis.annotations.*;
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(String username);
}