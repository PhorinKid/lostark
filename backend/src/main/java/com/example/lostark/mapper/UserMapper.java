package com.example.lostark.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.lostark.dto.User;

@Mapper
public interface UserMapper {
    void insertUser(User user);
    User findByUsername(String username);
    User findByEmail(String email);
}
