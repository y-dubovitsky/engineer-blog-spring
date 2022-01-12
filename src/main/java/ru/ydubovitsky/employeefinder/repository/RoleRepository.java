package ru.ydubovitsky.employeefinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ydubovitsky.employeefinder.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);

}
