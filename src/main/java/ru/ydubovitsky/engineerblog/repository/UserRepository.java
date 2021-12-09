package ru.ydubovitsky.engineerblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ydubovitsky.engineerblog.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
