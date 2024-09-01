package dev.pichborith.SkillsFlask.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepo;
    private final UserMapper userMapper;


    public UserResponse create(UserRequest request) {
        System.out.println(2);
        var user = userRepo.save(userMapper.toUser(request));
        System.out.println(user);
        return userMapper.toUserResponse(user);
    }
}
