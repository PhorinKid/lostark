package com.example.lostark.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.lostark.dto.Favorite;
import com.example.lostark.service.FavoriteService;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    // 즐겨찾기 추가
    @PostMapping("/add")
    public ResponseEntity<String> addFavorite(@RequestBody Favorite favorite) {
        try {
            favoriteService.addFavorite(favorite);
            return ResponseEntity.ok("즐겨찾기 추가 성공");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    // 즐겨찾기 삭제
    @DeleteMapping("/remove")
    public ResponseEntity<String> removeFavorite(@RequestBody Favorite favorite) {
        try {
            favoriteService.removeFavorite(favorite.getUserId(), favorite.getCharacterName());
            return ResponseEntity.ok("즐겨찾기 삭제 성공");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    // 즐겨찾기 조회
    @GetMapping("/list/{userId}")
    public ResponseEntity<List<Favorite>> listFavorites(@PathVariable Integer userId) {
        return ResponseEntity.ok(favoriteService.getFavorites(userId));
    }
}
