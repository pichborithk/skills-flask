package dev.pichborith.SkillsLabAcademy.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static dev.pichborith.SkillsLabAcademy.user.Permission.*;

@Getter
@RequiredArgsConstructor
public enum Role {

    USER(Collections.emptySet()),
    ADMIN(Set.of(ADMIN_READ, ADMIN_CREATE, ADMIN_UPDATE, ADMIN_DELETE,
                 INSTRUCTOR_READ, INSTRUCTOR_CREATE, INSTRUCTOR_UPDATE,
                 INSTRUCTOR_DELETE)),
    INSTRUCTOR(Set.of(INSTRUCTOR_READ, INSTRUCTOR_UPDATE, INSTRUCTOR_DELETE,
                    INSTRUCTOR_CREATE));

    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = getPermissions()
                                                       .stream()
                                                       .map(
                                                           permission -> new SimpleGrantedAuthority(
                                                               permission.getPermission()))
                                                       .collect(
                                                           Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}