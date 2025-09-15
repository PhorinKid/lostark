package com.example.lostark.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.lostark.entity.User;

@Mapper
public interface UserMapper {
    void insertUser(User user);
    User findByUsername(String username);
    User findByEmail(String email);
}