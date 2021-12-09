package ru.ydubovitsky.engineerblog.service;

import org.springframework.stereotype.Service;
import ru.ydubovitsky.engineerblog.dto.PostDto;
import ru.ydubovitsky.engineerblog.entity.Post;
import ru.ydubovitsky.engineerblog.entity.User;
import ru.ydubovitsky.engineerblog.repository.PostRepository;
import ru.ydubovitsky.engineerblog.repository.UserRepository;

import java.security.Principal;
import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;
    private UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post addPost(PostDto postDto, Principal principal) {
        String username = principal.getName();
        User user = userRepository.findByUsername(username);
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());

        Post savedPost = postRepository.save(post);
        user.getPosts().add(savedPost);
        return savedPost;
    }
}
