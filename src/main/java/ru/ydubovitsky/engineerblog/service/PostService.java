package ru.ydubovitsky.engineerblog.service;

import org.springframework.stereotype.Service;
import ru.ydubovitsky.engineerblog.entity.Post;
import ru.ydubovitsky.engineerblog.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }
}
