package ru.ydubovitsky.engineerblog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ydubovitsky.engineerblog.dto.UserDto;
import ru.ydubovitsky.engineerblog.entity.Skill;
import ru.ydubovitsky.engineerblog.entity.University;
import ru.ydubovitsky.engineerblog.entity.User;
import ru.ydubovitsky.engineerblog.entity.Work;
import ru.ydubovitsky.engineerblog.facade.UserFacade;
import ru.ydubovitsky.engineerblog.service.UserService;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> getUser(@PathVariable("username") String username) {
        User userByUsername = userService.getUserByUsername(username);
        if(Objects.isNull(userByUsername)) {
            return new ResponseEntity(String.format("%s not found", username), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(UserFacade.userToUserDto(userByUsername));
    }

    @GetMapping("/works/{username}")
    public ResponseEntity<List<Work>> getUserWorkList(@PathVariable("username") String username) {
        User user = userService.getUserByUsername(username);
        List<Work> works = user.getWorks();

        return ResponseEntity.ok(works);
    }

    @GetMapping("/university/{username}")
    public ResponseEntity<List<University>> getUserUniversityList(@PathVariable("username") String username) {
        User user = userService.getUserByUsername(username);
        List<University> universities = user.getUniversities();

        return ResponseEntity.ok(universities);
    }

    @GetMapping("/skills/{username}")
    public ResponseEntity<Set<Skill>> getUserSkillList(@PathVariable("username") String username) {
        User user = userService.getUserByUsername(username);
        Set<Skill> skills = user.getSkills();

        return ResponseEntity.ok(skills);
    }
}
