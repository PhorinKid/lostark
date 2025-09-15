package com.example.lostark.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    @Value("${jwt.expiration}")
    private long EXPIRATION_MS;

    @PostConstruct
    public void init() {
        System.out.println("=== JwtUtil 초기화 ===");
        System.out.println("SECRET_KEY: " + SECRET_KEY);
        System.out.println("EXPIRATION_MS: " + EXPIRATION_MS);
    }

    // 토큰 생성
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // 토큰에서 username 추출
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    // 토큰 유효성 체크
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
