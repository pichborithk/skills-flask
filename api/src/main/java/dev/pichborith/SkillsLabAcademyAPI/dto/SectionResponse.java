package dev.pichborith.SkillsLabAcademyAPI.dto;

import java.util.List;

public record SectionResponse(
    int id,
    int sequence,
    String title,
    List<LectureResponse> lectures
) {}
