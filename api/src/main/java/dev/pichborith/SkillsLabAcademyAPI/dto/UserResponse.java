package dev.pichborith.SkillsLabAcademyAPI.dto;

import dev.pichborith.SkillsLabAcademyAPI.models.Role;

public record UserResponse(
    int id,
    String username,
    Role role
) {
}
