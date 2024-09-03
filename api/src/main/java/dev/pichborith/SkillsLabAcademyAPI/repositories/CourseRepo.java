package dev.pichborith.SkillsLabAcademyAPI.repositories;

import dev.pichborith.SkillsLabAcademyAPI.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {
}
