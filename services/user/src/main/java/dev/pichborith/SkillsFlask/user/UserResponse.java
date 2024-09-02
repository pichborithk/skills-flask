package dev.pichborith.SkillsFlask.user;

public record UserResponse(
    String id,
    String firstname,
    String lastname,
    String email,
    Role role
) {
}
