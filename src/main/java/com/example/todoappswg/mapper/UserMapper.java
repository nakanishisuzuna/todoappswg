package com.example.todoappswg.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.todoappswg.model.User;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE email = #{email}")
    User findByEmail(@Param("email") String email);

    @Insert("INSERT INTO users (user_id,email, password) VALUES (#{userId},#{email}, #{password})")
    void insertUser(User user);

}
