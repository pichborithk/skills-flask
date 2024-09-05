package dev.pichborith.SkillsLabAcademyAPI.dto;

public record ErrorResponse(
    int statusCode,
    String error
) {
}
