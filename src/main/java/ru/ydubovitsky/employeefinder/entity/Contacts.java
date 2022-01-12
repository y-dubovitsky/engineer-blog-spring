package ru.ydubovitsky.employeefinder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "contacts_table")
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String phone;
    private String email;
    private String location;

    @JsonIgnore
    @OneToOne(optional = false, mappedBy = "contacts")
    private User user;

}
