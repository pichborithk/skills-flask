package dev.pichborith.SkillsLabAcademy.course;

import dev.pichborith.SkillsLabAcademy.user.UserResponse;

import java.math.BigDecimal;

public record CourseResponse(
    int id,
    String title,
    BigDecimal price,
    UserResponse author
) {
}
