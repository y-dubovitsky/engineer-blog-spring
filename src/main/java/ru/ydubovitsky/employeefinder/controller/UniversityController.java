package ru.ydubovitsky.employeefinder.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.ydubovitsky.employeefinder.dto.UniversityDto;
import ru.ydubovitsky.employeefinder.entity.University;
import ru.ydubovitsky.employeefinder.entity.User;
import ru.ydubovitsky.employeefinder.facade.UniversityFacade;
import ru.ydubovitsky.employeefinder.service.UniversityService;
import ru.ydubovitsky.employeefinder.service.UserService;

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
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public ResponseEntity<List<University>> getAllUniversityForUser(Principal principal) {
        User currentUser = userService.getUserByUsername(principal.getName());

        return ResponseEntity.ok(currentUser.getUniversities());
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public ResponseEntity<List<University>> getAllUniversity() {
        return ResponseEntity.ok(universityService.getAllUniversity());
    }



    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public ResponseEntity<Object> addUniversity(
            @RequestBody UniversityDto universityDto,
            Principal principal
    ) {
        University savedUniversity = universityService.saveUniversity(universityDto, principal);
        return ResponseEntity.ok(UniversityFacade.universityToUniversityDto(savedUniversity));
    }
}
