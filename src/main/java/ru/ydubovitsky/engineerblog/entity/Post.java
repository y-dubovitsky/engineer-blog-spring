package ru.ydubovitsky.engineerblog.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "post_table")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

}
