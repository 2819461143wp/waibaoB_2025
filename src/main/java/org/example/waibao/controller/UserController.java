package org.example.waibao.controller;

import org.example.waibao.pojo.User;
import org.example.waibao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, Object> payload) {
        System.out.println("接收到登录请求");
        System.out.println("请求数据：" + payload);
        String username = (String) payload.get("username");
        String password = (String) payload.get("password");
        if (username == null || password == null) {
            return ResponseEntity.badRequest().body("用户名或密码不能为空");
        }
        if (userService.login(username,password) != null) {
            return ResponseEntity.ok("登录成功");
        } else {
            return ResponseEntity.status(401).body("用户名或密码错误");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Map<String, Object> payload) {
        String username = (String) payload.get("username");
        String password = (String) payload.get("password");
        if (username == null || password == null) {
            return ResponseEntity.badRequest().body("用户名或密码不能为空");
        }
        if (userService.registerNewUser(username, password)) {
            return ResponseEntity.ok("注册成功");
        } else {
            return ResponseEntity.status(400).body("注册失败");
        }
    }

}
