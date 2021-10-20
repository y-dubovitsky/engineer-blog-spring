package ru.ydubovitsky.engineerblog.facade;

import ru.ydubovitsky.engineerblog.dto.WorkDto;
import ru.ydubovitsky.engineerblog.entity.Work;

public class WorkFacade {

    public static WorkDto workToWorkDto(Work work) {
        WorkDto workDto = new WorkDto();

        workDto.setName(work.getName());
        workDto.setAchievements(work.getAchievements());
        workDto.setPosition(work.getPosition());
        workDto.setFunction(work.getFunction());
        workDto.setStartDate(work.getStartDate());
        workDto.setEndDate(work.getEndDate());

        return workDto;
    }
}
