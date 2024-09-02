package dev.pichborith.SkillsFlask.exceptions;

public record ErrorResponse(
    int status,
    String error
) {
}
