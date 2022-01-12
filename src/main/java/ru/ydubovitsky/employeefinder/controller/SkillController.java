package ru.ydubovitsky.employeefinder.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ydubovitsky.employeefinder.dto.SkillDto;
import ru.ydubovitsky.employeefinder.entity.Skill;
import ru.ydubovitsky.employeefinder.facade.SkillFacade;
import ru.ydubovitsky.employeefinder.service.SkillService;

import java.security.Principal;

@RestController
@RequestMapping("/api/skill")
public class SkillController {

    private SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public ResponseEntity<SkillDto> addSkill(@RequestBody SkillDto skillDto, Principal principal) {
        Skill skill = skillService.addUserSkill(skillDto, principal);
        return ResponseEntity.ok(SkillFacade.skillToSkillDto(skill));
    }
}
