package dev.pichborith.SkillsLabAcademyAPI.services;

import dev.pichborith.SkillsLabAcademyAPI.dto.UserRequest;
import dev.pichborith.SkillsLabAcademyAPI.exceptions.ConflictException;
import dev.pichborith.SkillsLabAcademyAPI.exceptions.NotFoundException;
import dev.pichborith.SkillsLabAcademyAPI.exceptions.UnauthorizedException;
import dev.pichborith.SkillsLabAcademyAPI.mapper.UserMapper;
import dev.pichborith.SkillsLabAcademyAPI.models.User;
import dev.pichborith.SkillsLabAcademyAPI.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public User create(UserRequest request) {
        String username = request.username();
        if (userRepo.existsByUsername(username)) {
            throw new ConflictException(
                String.format("User with name: %s already exist", username));
        }

        User user = userMapper.toUser(request);
        return userRepo.save(user);
    }

    public User verify(UserRequest request) {
        String username = request.username();
        String password = request.password();
        User user = userRepo.findByUsername(username)
                            .orElseThrow(() -> new NotFoundException(
                                String.format("User with name: %s does not exist",
                                              username)));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new UnauthorizedException("Incorrect password");
        }

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(
        String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username)
                       .orElseThrow(() -> new UsernameNotFoundException(
                           "Username not found"));
    }


}
