package dev.pichborith.SkillsLabAcademy.user;

import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserResponse toUserResponse(User user) {
        return new UserResponse(user.getId(), user.getFirstname(),
                                user.getLastname(), user.getEmail(), user.getRole());
    }

    public User toUser(UserRequest request) {
        return new User(null, request.firstname(), request.lastname(),
                        request.email(), request.password(), request.role(), null);
    }
}
