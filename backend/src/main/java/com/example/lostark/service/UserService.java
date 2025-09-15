package com.example.lostark.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.lostark.entity.User;
import com.example.lostark.repository.UserMapper;
import com.example.lostark.util.JwtUtil;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserService(UserMapper userMapper, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // 회원가입
    public void register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.insertUser(user);
    }

    // 로그인
    public String login(String username, String password) {
        User user = userMapper.findByUsername(username);
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return jwtUtil.generateToken(username);
    }
}
