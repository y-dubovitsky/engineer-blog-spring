package ru.ydubovitsky.engineerblog.service;

import org.springframework.stereotype.Service;
import ru.ydubovitsky.engineerblog.entity.Role;
import ru.ydubovitsky.engineerblog.repository.RoleRepository;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public Role getById(Integer id) {
        return roleRepository.getById(id);
    }
}
