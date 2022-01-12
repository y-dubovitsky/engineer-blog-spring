package ru.ydubovitsky.employeefinder.service;

import org.springframework.stereotype.Service;
import ru.ydubovitsky.employeefinder.dto.UniversityDto;
import ru.ydubovitsky.employeefinder.entity.University;
import ru.ydubovitsky.employeefinder.entity.User;
import ru.ydubovitsky.employeefinder.repository.UniversityRepository;

import java.security.Principal;
import java.util.List;

@Service
public class UniversityService {

    private UniversityRepository universityRepository;

    private UserService userService;

    public UniversityService(UniversityRepository universityRepository, UserService userService) {
        this.universityRepository = universityRepository;
        this.userService = userService;
    }

    public List<University> getAllUniversity() {
        return universityRepository.findAll();
    }

    public University getUniversityByName(String universityName) {
        return universityRepository.findByName(universityName);
    }

    //FIXME Ужасный КОД!
    public University saveUniversity(UniversityDto universityDto, Principal principal) {
        User user = userService.getUserByUsername(principal.getName());

        University university = new University();
        university.setName(universityDto.getName());
        university.setCathedra(universityDto.getCathedra());
        university.setSpeciality(universityDto.getSpeciality());
        university.setStartYear(university.getStartYear());
        university.setEndYear(universityDto.getEndYear());
        university.setDescription(universityDto.getDescription());
        university.setUsers(List.of(user));
        universityRepository.save(university);

        user.getUniversities().add(university);
        userService.add(user);

        return university;
    }

}
