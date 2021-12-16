package ru.ydubovitsky.engineerblog.facade;

import ru.ydubovitsky.engineerblog.dto.PostDto;
import ru.ydubovitsky.engineerblog.entity.Post;

public class PostFacade {

    public static PostDto postToPostDto(Post post) {
        PostDto postDto = new PostDto();

        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());

        return postDto;
    }

}
