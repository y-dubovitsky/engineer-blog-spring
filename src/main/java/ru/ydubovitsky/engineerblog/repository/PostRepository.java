package ru.ydubovitsky.engineerblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ydubovitsky.engineerblog.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
