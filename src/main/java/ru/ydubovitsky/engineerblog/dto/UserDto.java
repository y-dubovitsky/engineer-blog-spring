package ru.ydubovitsky.engineerblog.dto;

import lombok.Data;
import ru.ydubovitsky.engineerblog.entity.Role;
import ru.ydubovitsky.engineerblog.repository.RoleRepository;
import ru.ydubovitsky.engineerblog.service.RoleService;

import java.util.Set;

@Data
public class UserDto {

    private RoleService roleService;

    private String username;
    private String password;
    private Set<Role> roles = Set.of(roleService.getById(1)); //FIXME Берется 1ая роль из БД

}
