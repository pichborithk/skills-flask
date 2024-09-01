package dev.pichborith.auth.auth;

import dev.pichborith.auth.user.UserClient;
import dev.pichborith.auth.user.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserClient userClient;
    private final JwtService jwtService;


    public AuthResponse register(UserRequest request) {
        var user = userClient.createUser(request).orElse(null);
        if (user == null) return null;

        var token = jwtService.generateToken(user);
        return new AuthResponse(token);
    }


}
