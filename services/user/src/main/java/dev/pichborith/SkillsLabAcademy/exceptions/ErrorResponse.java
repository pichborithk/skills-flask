package dev.pichborith.SkillsLabAcademy.exceptions;

public record ErrorResponse(
    int status,
    String error
) {
}
