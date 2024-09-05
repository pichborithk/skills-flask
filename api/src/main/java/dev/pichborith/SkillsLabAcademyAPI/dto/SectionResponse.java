package dev.pichborith.SkillsLabAcademyAPI.dto;

import java.util.List;

public record SectionResponse(
    int id,
    String title,
    List<LectureResponse> lectures
) {}
