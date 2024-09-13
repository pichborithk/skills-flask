package dev.pichborith.SkillsLabAcademyAPI.repositories;

import dev.pichborith.SkillsLabAcademyAPI.dto.SectionView;
import dev.pichborith.SkillsLabAcademyAPI.models.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SectionRepo extends JpaRepository<Section, Integer> {

    @Query("FROM Section s LEFT JOIN FETCH s.lectures WHERE s.id = :sectionId")
    Optional<Section> findByIdWithLectures(int sectionId);

    @Query(value = """
        SELECT s.*, c.title AS course_title, c.price, c.instructor_id, u.username AS instructor
        FROM sections AS s
        JOIN courses AS c ON c.course_id = s.course_id
        JOIN users AS u ON u.user_id = c.instructor_id
        WHERE s.section_id = :sectionId
        """, nativeQuery = true)
    Optional<SectionView> findViewById(int sectionId);

    // Shift sequence numbers greater than or equal to a given sequence
    @Modifying
    @Query("UPDATE Section s SET s.sequence = s.sequence + 1 WHERE s.sequence >= :sequence AND s.course.id = :courseId")
    void shiftSequenceUpFrom(int courseId, int sequence);

    // Shift sequence numbers after deletion
    @Modifying
    @Query("UPDATE Section s SET s.sequence = s.sequence - 1 WHERE s.sequence >= :sequence AND s.course.id = :courseId")
    void shiftSequenceDownFrom(int courseId, int sequence);


    // Shift sequences up by 1 between the new and old positions
    @Modifying
    @Query("UPDATE Section s SET s.sequence = s.sequence + 1 WHERE s.sequence < :currentSequence AND s.sequence >= :newSequence AND s.course.id = :courseId")
    void shiftSequenceUpBetween(int courseId, int currentSequence, int newSequence);

    // Shift sequences down by 1 between the old and new positions
    @Modifying
    @Query("UPDATE Section s SET s.sequence = s.sequence - 1 WHERE s.sequence > :currentSequence AND s.sequence <= :newSequence AND s.course.id = :courseId")
    void shiftSequenceDownBetween(int courseId, int currentSequence, int newSequence);
}
