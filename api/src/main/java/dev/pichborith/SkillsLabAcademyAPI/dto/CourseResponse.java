package dev.pichborith.SkillsLabAcademyAPI.dto;

import java.math.BigDecimal;
import java.util.List;

public record CourseResponse(
    int id,
    String title,
    BigDecimal price,
    UserResponse instructor,
    List<SectionResponse> sections
) {
}
