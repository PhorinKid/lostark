package com.example.lostark.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.lostark.dto.Favorite;

@Mapper
public interface FavoriteMapper {
    void insertFavorite(Favorite favorite);
    List<Favorite> findByUserId(Integer userId);
    void deleteFavorite(Integer id);
}
