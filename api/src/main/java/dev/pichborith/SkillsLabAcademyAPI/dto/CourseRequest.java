package dev.pichborith.SkillsLabAcademyAPI.dto;

import java.math.BigDecimal;

public record CourseRequest(
    String title,
    BigDecimal price
) {
}
