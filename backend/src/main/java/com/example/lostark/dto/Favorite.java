package com.example.lostark.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Favorite {
    private Integer favoriteId;
    private Integer userId;
    private String characterName;
    private LocalDateTime createdAt;
}
