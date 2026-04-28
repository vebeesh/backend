package com.example.mproject.service;

import com.example.mproject.entity.Post;
import com.example.mproject.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post createPost(Post post) {
        return repo.save(post);
    }

    public List<Post> getAllPosts() {
        return repo.findAll();
    }

    public void deletePost(int id) {
        repo.deleteById(id);
    }
}