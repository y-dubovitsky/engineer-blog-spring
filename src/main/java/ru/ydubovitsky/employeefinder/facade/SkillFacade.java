package ru.ydubovitsky.employeefinder.facade;

import ru.ydubovitsky.employeefinder.dto.SkillDto;
import ru.ydubovitsky.employeefinder.entity.Skill;

public class SkillFacade {

    public static SkillDto skillToSkillDto(Skill skill) {
        SkillDto skillDto = new SkillDto();

        skillDto.setName(skill.getName());
        skillDto.setLevel(skill.getLevel());

        return skillDto;
    }

}
