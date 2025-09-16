package com.example.lostark.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.lostark.dto.User;
import com.example.lostark.mapper.UserMapper;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    // 회원가입
    public void register(User user) {
        if (userMapper.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("이미 존재하는 사용자 이름입니다.");
        }
        if (userMapper.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("이미 존재하는 이메일입니다.");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.insertUser(user);
    }

    // 로그인
    public boolean login(String username, String password) {
        User user = userMapper.findByUsername(username);
        return user != null && passwordEncoder.matches(password, user.getPassword());
    }
}
