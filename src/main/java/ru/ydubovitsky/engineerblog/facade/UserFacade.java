package ru.ydubovitsky.engineerblog.facade;

import org.springframework.security.core.userdetails.UserDetails;
import ru.ydubovitsky.engineerblog.dto.UserDto;
import ru.ydubovitsky.engineerblog.entity.User;

public class UserFacade {

    public static UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setRoleSet(user.getRoles());

        return userDto;
    }

}
