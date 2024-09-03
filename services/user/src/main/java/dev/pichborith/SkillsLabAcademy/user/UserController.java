package dev.pichborith.SkillsLabAcademy.user;

import dev.pichborith.SkillsLabAcademy.configs.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
        @RequestBody UserRequest request) {
        var user = userService.create(request);
        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(new AuthResponse(token));

    }

    @GetMapping
    public ResponseEntity<UserResponse> getUser() {
        var user = userService.getCurrentUserDetails();
        return ResponseEntity.ok(user);

    }

//    @GetMapping
//    public ResponseEntity<UserResponse> getUserByEmail(@RequestParam String email) {
//        var user = userService.getByEmail(email);
//        return ResponseEntity.ok(user);
//    }

}
