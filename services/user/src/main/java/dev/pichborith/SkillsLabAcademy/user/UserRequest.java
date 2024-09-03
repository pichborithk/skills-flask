package dev.pichborith.SkillsLabAcademy.user;

public record UserRequest(
    String firstname,
    String lastname,
    String email,
    String password,
    Role role
) {
}
