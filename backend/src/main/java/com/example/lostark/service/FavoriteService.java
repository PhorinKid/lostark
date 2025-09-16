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
        // 중복 체크
        if (favoriteMapper.findByUserIdAndCharacterName(favorite.getUserId(), favorite.getCharacterName()) != null) {
            throw new RuntimeException("이미 즐겨찾기된 캐릭터입니다.");
        }
        favoriteMapper.insertFavorite(favorite);
    }

    public void removeFavorite(Integer userId, String characterName) {
        favoriteMapper.deleteFavorite(userId, characterName);
    }

    public List<Favorite> getFavorites(Integer userId) {
        return favoriteMapper.findByUserId(userId);
    }
}
