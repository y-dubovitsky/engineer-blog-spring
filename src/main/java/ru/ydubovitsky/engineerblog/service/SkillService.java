package ru.ydubovitsky.engineerblog.service;

import org.springframework.stereotype.Service;
import ru.ydubovitsky.engineerblog.dto.SkillDto;
import ru.ydubovitsky.engineerblog.entity.Skill;
import ru.ydubovitsky.engineerblog.entity.User;
import ru.ydubovitsky.engineerblog.repository.SkillRepository;
import ru.ydubovitsky.engineerblog.repository.UserRepository;

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
