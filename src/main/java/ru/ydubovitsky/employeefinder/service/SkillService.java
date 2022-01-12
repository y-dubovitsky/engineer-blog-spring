package ru.ydubovitsky.employeefinder.service;

import org.springframework.stereotype.Service;
import ru.ydubovitsky.employeefinder.dto.SkillDto;
import ru.ydubovitsky.employeefinder.entity.Skill;
import ru.ydubovitsky.employeefinder.entity.User;
import ru.ydubovitsky.employeefinder.repository.SkillRepository;
import ru.ydubovitsky.employeefinder.repository.UserRepository;

import java.security.Principal;

@Service
public class SkillService {

    private SkillRepository skillRepository;
    private UserRepository userRepository;

    public SkillService(SkillRepository skillRepository, UserRepository userRepository) {
        this.skillRepository = skillRepository;
        this.userRepository = userRepository;
    }

    public Skill addUserSkill(SkillDto skillDto, Principal principal) {
        User currentUser = userRepository.findByUsername(principal.getName());

        Skill skill = new Skill();
        skill.setUser(currentUser);
        skill.setLevel(skillDto.getLevel());
        skill.setName(skillDto.getName());

        return skillRepository.save(skill);
    }
}
