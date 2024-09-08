package dev.pichborith.SkillsLabAcademyAPI.mapper;

import dev.pichborith.SkillsLabAcademyAPI.dto.LectureResponse;
import dev.pichborith.SkillsLabAcademyAPI.dto.SectionRequest;
import dev.pichborith.SkillsLabAcademyAPI.dto.SectionResponse;
import dev.pichborith.SkillsLabAcademyAPI.models.Course;
import dev.pichborith.SkillsLabAcademyAPI.models.Section;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionMapper {

    public SectionResponse toSectionResponse(Section section) {
        return toSectionResponse(section, new ArrayList<>());
    }

    public SectionResponse toSectionResponse(Section section, List<LectureResponse> lectures) {
        return new SectionResponse(section.getId(), section.getSequence(), section.getTitle(), lectures);
    }

    public Section toSection(SectionRequest request, Course course) {
        return new Section(0, request.sequence(), request.title(), course, new ArrayList<>());
    }
}
