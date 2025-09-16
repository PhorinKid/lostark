package com.example.lostark.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.lostark.dto.Favorite;

@Mapper
public interface FavoriteMapper {
    void insertFavorite(Favorite favorite);
    void deleteFavorite(Integer userId, String characterName);
    List<Favorite> findByUserId(Integer userId);
    Favorite findByUserIdAndCharacterName(Integer userId, String characterName);
}
