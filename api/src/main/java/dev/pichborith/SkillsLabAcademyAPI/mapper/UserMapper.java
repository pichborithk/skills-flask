package dev.pichborith.SkillsLabAcademyAPI.mapper;

import dev.pichborith.SkillsLabAcademyAPI.dto.UserRequest;
import dev.pichborith.SkillsLabAcademyAPI.dto.UserResponse;
import dev.pichborith.SkillsLabAcademyAPI.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public User toUser(UserRequest request) {
        var password = passwordEncoder.encode(request.password());
        return new User(0, request.username(), password,
                        request.role());
    }

    public UserResponse toUserResponse(User user) {
        return new UserResponse(user.getId(), user.getUsername(), user.getRole());
    }
}
