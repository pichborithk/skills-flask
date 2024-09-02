package dev.pichborith.SkillsFlask.user;

import dev.pichborith.SkillsFlask.exceptions.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public UserResponse getById(String userId) {
        var user = userRepo.findById(userId).orElse(null);
        if (user == null) return null;
        return userMapper.toUserResponse(user);
    }


    public UserResponse getCurrentUserDetails() {
        var auth =  SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);
        System.out.println("auth above");
        if (auth == null || !(auth.getPrincipal() instanceof User)) {
            throw new UnauthorizedException("Invalid token");
        }

        return userMapper.toUserResponse((User) auth.getPrincipal());

    }
}
