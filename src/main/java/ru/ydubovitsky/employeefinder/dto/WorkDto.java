package ru.ydubovitsky.employeefinder.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class WorkDto {

    private String name;
    private String position;
    private Short startDate;
    private Short endDate;
    private String function;
    private String achievements;

}
