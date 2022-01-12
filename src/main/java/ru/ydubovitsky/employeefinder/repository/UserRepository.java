package ru.ydubovitsky.employeefinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ydubovitsky.employeefinder.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
