package com.skypro.Nplus1.controller;

import com.skypro.Nplus1.dto.PostDTO;
import com.skypro.Nplus1.dto.TopUsersDTO;
import com.skypro.Nplus1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private  PostService postService;

    @GetMapping("/top10")
    public ResponseEntity<List<TopUsersDTO>> getTopUsers() {
        return ResponseEntity.ok(postService.getTopUsers());
    }
    @GetMapping("/all")
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/all-pages")
    public ResponseEntity<List<PostDTO>> getAllPostsPages( Pageable pageable) {
        return ResponseEntity.ok(postService.getAllPostsPages(pageable));
    }

    @GetMapping("/comments")
    public ResponseEntity<List<PostDTO>> getPostsLike(@RequestParam String body) {
        return ResponseEntity.ok(postService.getPostLike(body));
    }
}