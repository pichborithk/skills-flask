package dev.pichborith.SkillsLabAcademyAPI.repositories;

import dev.pichborith.SkillsLabAcademyAPI.dto.LectureView;
import dev.pichborith.SkillsLabAcademyAPI.models.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LectureRepo extends JpaRepository<Lecture, Integer> {


    @Query(value = """
        SELECT l.*, s.sequence AS section_sequence, s.title AS section_title,
        c.course_id, c.title AS course_title, c.price, c.instructor_id, u.username AS instructor
        FROM lectures AS l
        JOIN sections AS s ON s.section_id = l.section_id
        JOIN courses AS c ON c.course_id = s.course_id
        JOIN users AS u ON u.user_id = c.instructor_id
        WHERE l.lecture_id = :lectureId
        """, nativeQuery = true)
    Optional<LectureView> findViewById(int lectureId);
}
