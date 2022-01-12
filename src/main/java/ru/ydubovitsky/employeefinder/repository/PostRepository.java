package ru.ydubovitsky.employeefinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ydubovitsky.employeefinder.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
