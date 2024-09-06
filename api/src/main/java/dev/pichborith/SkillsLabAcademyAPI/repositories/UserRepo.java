package dev.pichborith.SkillsLabAcademyAPI.repositories;

import dev.pichborith.SkillsLabAcademyAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);
}
