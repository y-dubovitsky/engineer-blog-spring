package ru.ydubovitsky.comment.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ydubovitsky.comment.entity.Comment;
import ru.ydubovitsky.comment.repository.CommentRepository;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Comment getCommentById(Long id) {
        return Comment.builder()
                .title("Title")
                .text("Some text")
                .build();
    }

}
