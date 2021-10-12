package ru.ydubovitsky.engineerblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ydubovitsky.engineerblog.dto.UserDto;
import ru.ydubovitsky.engineerblog.entity.Role;
import ru.ydubovitsky.engineerblog.entity.User;
import ru.ydubovitsky.engineerblog.repository.UserRepository;

import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleService roleService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(UserDto userDto) {
        User user = new User();
        user.setRoles(userDto.getRoles());
        user.setUsername(userDto.getUsername());
        user.setPassword(bcryptEncoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }

}
