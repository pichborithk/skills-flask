package dev.pichborith.auth.user;

public record UserRequest(
    String firstname,
    String lastname,
    String email,
    String password
) {
}
