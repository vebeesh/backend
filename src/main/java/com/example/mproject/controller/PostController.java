package com.example.mproject.controller;

import com.example.mproject.entity.Post;
import com.example.mproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:3001")
public class PostController {

    @Autowired
    private PostService service;

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return service.createPost(post); // ✅ FIXED HERE
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return service.getAllPosts();
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {
        service.deletePost(id);
    }
}