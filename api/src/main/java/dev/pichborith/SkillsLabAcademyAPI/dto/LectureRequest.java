package dev.pichborith.SkillsLabAcademyAPI.dto;

public record LectureRequest(
    int sequence,
    String title,
    int length,
    int sectionId
) {
}
