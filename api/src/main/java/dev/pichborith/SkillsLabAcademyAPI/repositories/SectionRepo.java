package dev.pichborith.SkillsLabAcademyAPI.repositories;

import dev.pichborith.SkillsLabAcademyAPI.models.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SectionRepo extends JpaRepository<Section, Integer> {

    @Query("FROM Section s JOIN FETCH s.lectures WHERE s.id = :sectionId")
    Optional<Section> findByIdWithLectures(int sectionId);
}
