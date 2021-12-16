package ru.ydubovitsky.engineerblog.facade;

import ru.ydubovitsky.engineerblog.dto.UserDto;
import ru.ydubovitsky.engineerblog.entity.User;

import java.util.stream.Collectors;

public class UserFacade {

    public static UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setContacts(user.getContacts());
        userDto.setUserAbout(user.getUserAbout());
        userDto.setCompetences(user.getCompetences());
        userDto.setSkills(user.getSkills());
        userDto.setWorks(user.getWorks());
        userDto.setUniversities(user.getUniversities());
        userDto.setRoleSet(user.getRoles().stream().map(role -> role.getName()).collect(Collectors.toSet()));

        return userDto;
    }

}
