package ru.ydubovitsky.engineerblog.facade;

import org.springframework.stereotype.Component;
import ru.ydubovitsky.engineerblog.dto.PostDto;
import ru.ydubovitsky.engineerblog.entity.Post;

@Component
public class PostFacade {

    public PostDto postToPostDto(Post post) {
        PostDto postDto = new PostDto();

        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());

        return postDto;
    }

}
