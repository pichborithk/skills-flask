package dev.pichborith.SkillsLabAcademyAPI.dto;

import java.math.BigDecimal;

public interface SectionView {
    int getSectionId();
    int getSequence();
    String getTitle();
    int getCourseId();
    String getCourseTitle();
    BigDecimal getPrice();
    int getInstructorId();
    String getInstructor();
}
