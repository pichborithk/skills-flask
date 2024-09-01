package dev.pichborith.auth.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(
    name = "user-service",
    url = "${application.config.user-url}"
)
public interface UserClient {

    @GetMapping("/{userID}")
    Optional<UserResponse> getUserById(@PathVariable String userId);

    @PostMapping
    Optional<UserResponse> createUser(@RequestBody UserRequest request);
}
