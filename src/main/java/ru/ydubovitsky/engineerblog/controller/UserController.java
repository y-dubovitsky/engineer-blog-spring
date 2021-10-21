package ru.ydubovitsky.engineerblog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ydubovitsky.engineerblog.entity.Skill;
import ru.ydubovitsky.engineerblog.entity.User;
import ru.ydubovitsky.engineerblog.entity.Work;
import ru.ydubovitsky.engineerblog.service.UserService;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/works")
    public ResponseEntity<List<Work>> getUserWorkList(Principal principal) {
        User currentUser = userService.getUserByUsername(principal.getName());

        return ResponseEntity.ok(currentUser.getWorks());
    }

    @GetMapping("/skills")
    public ResponseEntity<Set<Skill>> getUserSkillList(Principal principal) {
        User currentUser = userService.getUserByUsername(principal.getName());

        return ResponseEntity.ok(currentUser.getSkills());
    }
}
