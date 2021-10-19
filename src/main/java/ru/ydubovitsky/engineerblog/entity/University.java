package ru.ydubovitsky.engineerblog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "university_table")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String speciality;
    private String cathedra;
    private Short startYear;
    private Short endYear;
    private String description;

    @JsonIgnore
    @ManyToMany(mappedBy = "universities")
    private List<User> users; //TODO Заменить на сет?
}
