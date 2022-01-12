package ru.ydubovitsky.employeefinder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user_table")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    @JsonIgnore
    private String password;

    @Column
    private String githubProfileName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userAbout_id")
    private UserAbout userAbout;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contacts_id")
    private Contacts contacts;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    @OneToMany(mappedBy="user")
    private Set<Competence> competences;

    @JsonIgnore //TODO Зачем нужна она?
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_university", // Имя создаваемой таблицы
            joinColumns = @JoinColumn(name = "user_id"), // Колонка 1
            inverseJoinColumns = @JoinColumn(name = "university_id")) // Колонка 2
    private List<University> universities;

    @OneToMany(mappedBy="user") // user - имя сущности!
    private List<Work> works;

    @OneToMany(mappedBy="user") // user - имя сущности!
    private List<Post> posts;

    @OneToMany(mappedBy = "user")
    private Set<Skill> skills;


    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isCredentialsNonExpired = true;
    private boolean isEnabled = true;
}
