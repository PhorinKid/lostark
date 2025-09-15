package com.example.lostark.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lostark.entity.User;
import com.example.lostark.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            userService.register(user);
            return ResponseEntity.ok("회원가입 성공");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        try {
            String token = userService.login(loginRequest.get("username"), loginRequest.get("password"));
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}
