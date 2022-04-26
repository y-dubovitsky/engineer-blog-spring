package ru.ydubovitsky.engineerBlog.security.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.ydubovitsky.engineerBlog.entity.Contacts;
import ru.ydubovitsky.engineerBlog.entity.enums.Role;

import java.util.Set;

@Builder
@Getter @Setter
public class AuthResponse {

    private String jwttoken;
    private String username;
    private String firstName;
    private String lastName;
    private String about;
    private Contacts contacts;
    private Set<Role> roles;

}
