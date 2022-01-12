package ru.ydubovitsky.employeefinder.facade;

import ru.ydubovitsky.employeefinder.dto.PostDto;
import ru.ydubovitsky.employeefinder.entity.Post;

public class PostFacade {

    public static PostDto postToPostDto(Post post) {
        PostDto postDto = new PostDto();

        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());

        return postDto;
    }

}
