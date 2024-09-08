package dev.pichborith.SkillsLabAcademyAPI.dto;

import java.math.BigDecimal;

public interface LectureView {
    int getLectureId();
    int getSequence();
    String getTitle();
    int getLength();
    int getSectionId();
    int getSectionSequence();
    String getSectionTitle();
    int getCourseId();
    String getCourseTitle();
    BigDecimal getPrice();
    int getInstructorId();
    String getInstructor();
}
