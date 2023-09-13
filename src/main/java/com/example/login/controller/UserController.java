package com.example.login.controller;

import com.example.login.entity.UserEntity;
import com.example.login.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/signup")
    public ResponseEntity<Object> Signup(String id, String pw, String name){
        userService.signup(id, pw, name);

        return ResponseEntity.ok().body("success");
    }

    @GetMapping("/login")
    public ResponseEntity<Object> Login(String id, String pw){
        String string = userService.login(id, pw);

        return ResponseEntity.ok().body(string);
    }
}
