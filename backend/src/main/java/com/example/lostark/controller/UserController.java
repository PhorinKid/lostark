package com.example.lostark.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lostark.dto.User;
import com.example.lostark.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            userService.register(user);
            return ResponseEntity.ok("회원가입 성공");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        boolean success = userService.login(loginRequest.get("username"), loginRequest.get("password"));
        if (success) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "로그인 성공");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body("아이디 또는 비밀번호가 잘못되었습니다.");
        }
    }
}
