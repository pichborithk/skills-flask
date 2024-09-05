package dev.pichborith.SkillsLabAcademyAPI.dto;

import java.math.BigDecimal;

public record CourseResponse(
    int id,
    String title,
    BigDecimal price,
    UserResponse instructor
) {
}
