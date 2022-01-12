package ru.ydubovitsky.employeefinder.facade;

import ru.ydubovitsky.employeefinder.dto.UniversityDto;
import ru.ydubovitsky.employeefinder.entity.University;

public class UniversityFacade { // Фасад - это сущность, которую мы выставялем 'наружу' пользователю

    public static UniversityDto universityToUniversityDto(University university) {
        UniversityDto universityDto = new UniversityDto();
        universityDto.setName(university.getName());
        universityDto.setCathedra(university.getCathedra());
        universityDto.setSpeciality(university.getSpeciality());
        universityDto.setStartYear(university.getStartYear());
        universityDto.setEndYear(university.getEndYear());
        universityDto.setDescription(university.getDescription());

        return universityDto;
    }

}
