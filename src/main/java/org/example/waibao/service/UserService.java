package org.example.waibao.service;

import org.example.waibao.mapper.UserMapper;
import org.example.waibao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Boolean registerNewUser(String username, String password) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUsername(username);
        user.setPassword(password);
        return userMapper.registerNewUser(user);
    }

    public User login(String username, String password) {
        return userMapper.login(username, password);
    }
}