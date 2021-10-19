package ru.ydubovitsky.engineerblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ydubovitsky.engineerblog.entity.University;
import ru.ydubovitsky.engineerblog.entity.User;

import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
