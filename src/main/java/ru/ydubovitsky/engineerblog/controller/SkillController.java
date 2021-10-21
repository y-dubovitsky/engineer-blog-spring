package ru.ydubovitsky.engineerblog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ydubovitsky.engineerblog.dto.SkillDto;
import ru.ydubovitsky.engineerblog.entity.Skill;
import ru.ydubovitsky.engineerblog.facade.SkillFacade;
import ru.ydubovitsky.engineerblog.service.SkillService;

import java.security.Principal;

@RestController
@RequestMapping("/api/skill")
public class SkillController {

    private SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping("/add")
    public ResponseEntity<SkillDto> addSkill(@RequestBody SkillDto skillDto, Principal principal) {
        Skill skill = skillService.addUserSkill(skillDto, principal);

        return ResponseEntity.ok(SkillFacade.skillToSkillDto(skill));
    }
}
