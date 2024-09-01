package dev.pichborith.SkillsFlask.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepo;
    private final UserMapper userMapper;


    public UserResponse create(UserRequest request) {
        var user = userRepo.save(userMapper.toUser(request));
        return userMapper.toUserResponse(user);
    }
}
