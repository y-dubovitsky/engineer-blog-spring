package ru.ydubovitsky.engineerblog.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ydubovitsky.engineerblog.entity.Role;

import java.util.Set;

@Data
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private String email;
    private Set<Role> roleSet;
}
