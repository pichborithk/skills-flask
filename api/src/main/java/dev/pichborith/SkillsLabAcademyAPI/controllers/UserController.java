package dev.pichborith.SkillsLabAcademyAPI.controllers;

import dev.pichborith.SkillsLabAcademyAPI.dto.UserResponse;
import dev.pichborith.SkillsLabAcademyAPI.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "${CLIENT_URL}")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ResponseBody
    @GetMapping
    public UserResponse getUser() {
        return userService.getCurrentUserDetails();
    }
}
