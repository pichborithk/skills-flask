package dev.pichborith.SkillsLabAcademyAPI.services;

import dev.pichborith.SkillsLabAcademyAPI.dto.UserRequest;
import dev.pichborith.SkillsLabAcademyAPI.exceptions.ConflictException;
import dev.pichborith.SkillsLabAcademyAPI.mapper.UserMapper;
import dev.pichborith.SkillsLabAcademyAPI.models.User;
import dev.pichborith.SkillsLabAcademyAPI.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public User create(UserRequest request) {
        String username = request.username();
        if (userRepo.existsByUsername(username)) {
            throw new ConflictException(
                String.format("User with name: %s already exist", username));
        }

        User user = userMapper.toUser(request);
        return userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(
        String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username)
                       .orElseThrow(() -> new UsernameNotFoundException(
                           "Username not found"));
    }
}
