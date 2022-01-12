package ru.ydubovitsky.employeefinder.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.ydubovitsky.employeefinder.dto.WorkDto;
import ru.ydubovitsky.employeefinder.entity.Work;
import ru.ydubovitsky.employeefinder.facade.WorkFacade;
import ru.ydubovitsky.employeefinder.service.WorkService;

import java.security.Principal;

@RestController
@RequestMapping("/api/work")
public class WorkController {

    private WorkService workService;

    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public ResponseEntity<WorkDto> addUserWork(
            @RequestBody WorkDto workDto,
            Principal principal
    ) {
        Work response = workService.addUserWork(workDto, principal);

        return ResponseEntity.ok(WorkFacade.workToWorkDto(response));
    }
}
