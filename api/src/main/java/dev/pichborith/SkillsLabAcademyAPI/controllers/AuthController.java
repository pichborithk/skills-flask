package dev.pichborith.SkillsLabAcademyAPI.controllers;

import dev.pichborith.SkillsLabAcademyAPI.dto.AuthResponse;
import dev.pichborith.SkillsLabAcademyAPI.dto.UserRequest;
import dev.pichborith.SkillsLabAcademyAPI.services.JwtService;
import dev.pichborith.SkillsLabAcademyAPI.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "${CLIENT_URL}")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping("register")
    @ResponseBody
    public AuthResponse register(@RequestBody UserRequest request) {
        var user = userService.create(request);
        String token = jwtService.generateToken(user);
        return new AuthResponse(token);
    }

    @PostMapping("login")
    @ResponseBody
    public AuthResponse login(@RequestBody UserRequest request) {
        var user = userService.verify(request);
        String token = jwtService.generateToken(user);
        return new AuthResponse(token);
    }

}
