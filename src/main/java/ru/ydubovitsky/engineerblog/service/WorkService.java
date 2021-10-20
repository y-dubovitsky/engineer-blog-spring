package ru.ydubovitsky.engineerblog.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.ydubovitsky.engineerblog.dto.WorkDto;
import ru.ydubovitsky.engineerblog.entity.User;
import ru.ydubovitsky.engineerblog.entity.Work;
import ru.ydubovitsky.engineerblog.repository.UserRepository;
import ru.ydubovitsky.engineerblog.repository.WorkRepository;

import java.security.Principal;

@Service
public class WorkService {

    private final Logger LOGGER = LoggerFactory.getLogger(WorkService.class);

    private WorkRepository workRepository;
    private UserRepository userRepository;

    public WorkService(WorkRepository workRepository, UserRepository userRepository) {
        this.workRepository = workRepository;
        this.userRepository = userRepository;
    }

    public Work addUserWork(WorkDto workDto, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());

        Work work = new Work();
        work.setName(workDto.getName());
        work.setAchievements(workDto.getPosition());
        work.setPosition(workDto.getPosition());
        work.setFunction(workDto.getFunction());
        work.setStartDate(workDto.getStartDate());
        work.setEndDate(workDto.getEndDate());
        work.setUser(user);

        Work savedWork = workRepository.save(work);
        LOGGER.info(work.getName() + " saved!");
        user.getWorks().add(work);

        userRepository.save(user);
        LOGGER.info(user.getUsername() + " updated!");

        return savedWork;
    }
}
