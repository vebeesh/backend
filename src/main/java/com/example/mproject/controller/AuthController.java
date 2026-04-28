package com.example.mproject.controller;

import com.example.mproject.dto.LoginRequest;
import com.example.mproject.entity.User;
import com.example.mproject.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private AuthService service;

    // ✅ LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        User user = service.login(request.getEmail(), request.getPassword());

        if (user != null) {
            return ResponseEntity.ok(user); // ✅ return user object
        } else {
            return ResponseEntity.status(401).body("Invalid Credentials");
        }
    }

    // ✅ REGISTER
    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return service.register(user);
    }
}