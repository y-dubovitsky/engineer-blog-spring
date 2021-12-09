package ru.ydubovitsky.engineerblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ydubovitsky.engineerblog.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);

}
