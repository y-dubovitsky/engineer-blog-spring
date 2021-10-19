package ru.ydubovitsky.engineerblog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ydubovitsky.engineerblog.dto.UniversityDto;
import ru.ydubovitsky.engineerblog.entity.University;
import ru.ydubovitsky.engineerblog.entity.User;
import ru.ydubovitsky.engineerblog.facade.UniversityFacade;
import ru.ydubovitsky.engineerblog.service.UniversityService;
import ru.ydubovitsky.engineerblog.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/university")
public class UniversityController {

    private UniversityService universityService;

    private UserService userService;

    public UniversityController(UniversityService universityService, UserService userService) {
        this.universityService = universityService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<University>> getAllUniversityForUser(Principal principal) {
        User currentUser = userService.getUserByUsername(principal.getName());

        return ResponseEntity.ok(currentUser.getUniversities());
    }

    @GetMapping("/all")
//    @Secured("ROLE_USER")
    public ResponseEntity<List<University>> getAllUniversity() {
        return ResponseEntity.ok(universityService.getAllUniversity());
    }



    @PostMapping("/add")
//    @Secured("ROLE_USER")
    public ResponseEntity<Object> addUniversity(
            @RequestBody UniversityDto universityDto,
            Principal principal
    ) {
        University savedUniversity = universityService.saveUniversity(universityDto, principal);

        return ResponseEntity.ok(UniversityFacade.universityToUniversityDto(savedUniversity));
    }
}
