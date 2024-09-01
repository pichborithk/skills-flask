package dev.pichborith.SkillsFlask.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity<UserResponse> createUser(
        @RequestBody UserRequest request) {
        System.out.println(1);
        var user = userService.create(request);
        return ResponseEntity.ok(user);

    }
}
