package com.example.mproject.service;

import com.example.mproject.entity.User;
import com.example.mproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthService {

    @Autowired
    private UserRepository repo;

    // ✅ LOGIN
    public User login(String email, String password) {

        User user = repo.findByEmail(email.trim());

        if (user != null && user.getPassword().equals(password.trim())) {

            user.setLastLogin(LocalDateTime.now());
            repo.save(user);

            return user;
        }

        return null; // ❌ DO NOT THROW EXCEPTION
    }

    // ✅ REGISTER
    public String register(User user) {

        User existing = repo.findByEmail(user.getEmail());

        if (existing != null) {
            return "Email already exists";
        }

        user.setCreatedAt(LocalDateTime.now());
        repo.save(user);

        return "Registered Successfully";
    }
}