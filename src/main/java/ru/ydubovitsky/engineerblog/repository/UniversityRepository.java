package ru.ydubovitsky.engineerblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ydubovitsky.engineerblog.entity.University;

public interface UniversityRepository extends JpaRepository<University, Integer> {

    University findByName(String universityName);

}