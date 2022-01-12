package ru.ydubovitsky.employeefinder.service;

import org.springframework.stereotype.Service;
import ru.ydubovitsky.employeefinder.entity.Role;
import ru.ydubovitsky.employeefinder.repository.RoleRepository;

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

    public Role getByName(String name) {
        return roleRepository.findByName(name);
    }
}
