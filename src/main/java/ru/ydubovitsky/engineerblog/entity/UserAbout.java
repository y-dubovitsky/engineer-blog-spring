package ru.ydubovitsky.engineerblog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "userAbout_table")
public class UserAbout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String speciality;

    public String about;

    public Short successProjectCount;

    @OneToMany(mappedBy="userAbout")
    public List<UserAboutTag> userAboutTag;

    @JsonIgnore
    @OneToOne(mappedBy = "userAbout")
    public User user;

}
