package ru.ydubovitsky.employeefinder.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.ydubovitsky.employeefinder.entity.*;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private Contacts contacts;
    private UserAbout userAbout;
    private String githubProfileName;
    private Set<Competence> competences;
    private List<University> universities;
    private List<Work> works;
    private Set<Skill> skills;
    private Set<String> roleSet;
}
