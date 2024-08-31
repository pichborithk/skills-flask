package dev.pichborith.SkillsFlask.course;

import dev.pichborith.SkillsFlask.user.UserResponse;

import java.math.BigDecimal;

public record CourseResponse(
    int id,
    String title,
    BigDecimal price,
    UserResponse author
) {
}
