package ru.ydubovitsky.employeefinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ydubovitsky.employeefinder.entity.University;

public interface UniversityRepository extends JpaRepository<University, Integer> {

    University findByName(String universityName);

}