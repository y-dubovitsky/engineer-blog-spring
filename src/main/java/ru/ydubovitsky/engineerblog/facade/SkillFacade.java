package ru.ydubovitsky.engineerblog.facade;

import ru.ydubovitsky.engineerblog.dto.SkillDto;
import ru.ydubovitsky.engineerblog.entity.Skill;

public class SkillFacade {

    public static SkillDto skillToSkillDto(Skill skill) {
        SkillDto skillDto = new SkillDto();

        skillDto.setName(skill.getName());
        skillDto.setLevel(skill.getLevel());

        return skillDto;
    }

}
