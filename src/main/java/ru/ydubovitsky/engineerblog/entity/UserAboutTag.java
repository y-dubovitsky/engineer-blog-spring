package ru.ydubovitsky.engineerblog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "userAboutTag_table")
public class UserAboutTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String icon;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "userAbout_id")
    private UserAbout userAbout;

}
