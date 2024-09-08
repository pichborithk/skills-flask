package dev.pichborith.SkillsLabAcademyAPI.dto;

public record SectionRequest(
    int sequence,
    String title,
    int courseId
) {
}
