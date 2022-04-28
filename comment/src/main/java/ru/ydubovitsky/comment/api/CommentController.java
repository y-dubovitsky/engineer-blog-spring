package ru.ydubovitsky.comment.api;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ydubovitsky.comment.entity.Comment;
import ru.ydubovitsky.comment.service.CommentService;

@RestController
@RequestMapping("/api/v1/comment")
@AllArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Comment commentById = commentService.getCommentById(id);
        return ResponseEntity.ok(commentById);
    }

}
