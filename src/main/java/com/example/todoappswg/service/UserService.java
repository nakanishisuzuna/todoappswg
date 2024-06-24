package com.example.todoappswg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.todoappswg.mapper.UserMapper;
import com.example.todoappswg.model.User;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.insertUser(user);
    }
    
    public void logout(User user) {

    	}

    public User findByEmail(String email) {
        return userMapper.findByEmail(email);
    }
    
}
