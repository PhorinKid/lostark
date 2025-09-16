package com.example.lostark.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Favorite {
    private Integer id;
    private Integer user_id;
    private String character_name;
    private LocalDateTime created_at;
}
