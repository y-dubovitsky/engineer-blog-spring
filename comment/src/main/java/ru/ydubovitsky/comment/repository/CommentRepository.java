package ru.ydubovitsky.comment.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.ydubovitsky.comment.entity.Comment;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
}
