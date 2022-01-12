package ru.ydubovitsky.employeefinder.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ydubovitsky.employeefinder.dto.UserDto;
import ru.ydubovitsky.employeefinder.entity.Role;
import ru.ydubovitsky.employeefinder.entity.User;
import ru.ydubovitsky.employeefinder.facade.UserFacade;
import ru.ydubovitsky.employeefinder.service.RoleService;
import ru.ydubovitsky.employeefinder.service.UserService;

import java.util.Objects;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final RoleService roleService;

    public AuthController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    //TODO Добавить разные валидации
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
        User userByUsername = userService.getUserByUsername(userDto.getUsername());
        if(Objects.isNull(userByUsername)) {
            User user = new User();
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());

            Role userRole = roleService.getByName("ROLE_USER");
            user.setRoles(Set.of(userRole));
            User savedUser = userService.add(user);
            log.info(String.format("%s saved in database", user.getUsername()));
            return ResponseEntity.ok(UserFacade.userToUserDto(savedUser));
        }
        return new ResponseEntity<>(String.format("%s already exists", userDto.getUsername()), HttpStatus.BAD_REQUEST);
    }
}
