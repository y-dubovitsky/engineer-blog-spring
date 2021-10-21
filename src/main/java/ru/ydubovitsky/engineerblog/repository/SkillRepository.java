package ru.ydubovitsky.engineerblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ydubovitsky.engineerblog.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
}
