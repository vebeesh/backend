package com.example.mproject.controller;

import com.example.mproject.entity.User;
import com.example.mproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository repo;

    // GET USERS
    @GetMapping
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    // CREATE USER ✅ FIXED
    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setCreatedAt(LocalDateTime.now());
        return repo.save(user);
    }
}