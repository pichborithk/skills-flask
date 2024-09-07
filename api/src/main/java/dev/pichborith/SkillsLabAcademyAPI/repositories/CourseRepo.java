package dev.pichborith.SkillsLabAcademyAPI.repositories;

import dev.pichborith.SkillsLabAcademyAPI.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CourseRepo extends JpaRepository<Course, Integer> {

    // This is method for query courses join with instructors if Fetch Type is Lazy
    @Query("FROM Course c JOIN FETCH c.instructor")
    List<Course> findAllWithInstructor();

    @Query("FROM Course c JOIN FETCH c.sections WHERE c.id = :courseId")
    Optional<Course> findByIdWithSections(int courseId);

    List<Course> findAllByInstructorId(int instructorId);
}
