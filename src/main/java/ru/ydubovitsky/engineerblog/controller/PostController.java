package ru.ydubovitsky.engineerblog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ru.ydubovitsky.engineerblog.dto.PostDto;
import ru.ydubovitsky.engineerblog.entity.Post;
import ru.ydubovitsky.engineerblog.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> all = postService.getAllPosts();
        return ResponseEntity.ok(all);
    }

    @PostMapping("/add")
//    @Secured("ROLE_USER") //! Важно, что роли должны начинаться со строки ROLE!
    public ResponseEntity<Object> addPost(@RequestBody PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());

        Post savedPost = postService.savePost(post);
        System.out.println(savedPost);
        return ResponseEntity.ok(savedPost);
    }
}
