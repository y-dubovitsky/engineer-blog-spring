package ru.ydubovitsky.engineerblog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ydubovitsky.engineerblog.dto.WorkDto;
import ru.ydubovitsky.engineerblog.entity.Work;
import ru.ydubovitsky.engineerblog.facade.WorkFacade;
import ru.ydubovitsky.engineerblog.service.WorkService;

import java.security.Principal;

@RestController
@RequestMapping("/api/work")
public class WorkController {

    private WorkService workService;

    public WorkController(WorkService workService) {
        this.workService = workService;
    }

    @PostMapping("/add")
    public ResponseEntity<WorkDto> addUserWork(
            @RequestBody WorkDto workDto,
            Principal principal
    ) {
        Work response = workService.addUserWork(workDto, principal);

        return ResponseEntity.ok(WorkFacade.workToWorkDto(response));
    }
}
