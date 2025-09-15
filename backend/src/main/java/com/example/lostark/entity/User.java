package com.example.lostark.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class User {
    private Integer userId;
    private String username;
    private String password;
    private String email;
    private LocalDateTime createdAt;
}