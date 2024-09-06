package dev.pichborith.SkillsLabAcademyAPI.dto;

import dev.pichborith.SkillsLabAcademyAPI.models.Role;

public record UserRequest(
    String username,
    String password,
    Role role
) {
}
