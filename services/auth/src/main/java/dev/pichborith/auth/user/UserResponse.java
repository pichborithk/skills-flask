package dev.pichborith.auth.user;

public record UserResponse(
    String id,
    String firstname,
    String lastname,
    String email
) {
}
