package dev.pichborith.SkillsFlask.user;

public record UserRequest(
    String firstname,
    String lastname,
    String email,
    String password,
    Role role
) {
}
