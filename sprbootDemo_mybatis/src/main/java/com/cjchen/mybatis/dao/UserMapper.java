package com.cjchen.mybatis.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cjchen.mybatis.modle.User;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM CJ_USERS WHERE NAME = #{name}")
    User findByName(@Param("name") String name);
    @Insert("INSERT INTO CJ_USERS(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);
}