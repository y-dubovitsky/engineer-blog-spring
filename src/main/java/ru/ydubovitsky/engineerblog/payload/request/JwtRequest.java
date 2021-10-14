package ru.ydubovitsky.engineerblog.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ydubovitsky.engineerblog.entity.Role;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String username;
    private String password;
    private Set<Role> roles;

    public JwtRequest() {
        //FIXME Добавил роли по умолчанию
        this.roles = Set.of(new Role(1, "ROLE_USER"));
    }
}
