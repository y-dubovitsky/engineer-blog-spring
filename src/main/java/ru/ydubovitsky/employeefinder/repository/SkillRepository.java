package ru.ydubovitsky.employeefinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ydubovitsky.employeefinder.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
}
