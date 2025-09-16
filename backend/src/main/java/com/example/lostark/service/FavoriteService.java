package com.example.lostark.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.lostark.dto.Favorite;
import com.example.lostark.mapper.FavoriteMapper;

@Service
public class FavoriteService {
    private final FavoriteMapper favoriteMapper;

    public FavoriteService(FavoriteMapper favoriteMapper) {
        this.favoriteMapper = favoriteMapper;
    }

    public void addFavorite(Favorite favorite) {
        favoriteMapper.insertFavorite(favorite);
    }

    public List<Favorite> getFavorites(Integer userId) {
        return favoriteMapper.findByUserId(userId);
    }

    public void removeFavorite(Integer id) {
        favoriteMapper.deleteFavorite(id);
    }
}
