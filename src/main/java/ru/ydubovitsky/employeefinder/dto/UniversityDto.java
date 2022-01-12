package ru.ydubovitsky.employeefinder.dto;

import lombok.Data;

@Data
public class UniversityDto {

    public String name;
    public String speciality;
    public String cathedra;
    public Short startYear;
    public Short endYear;
    public String description;

}
