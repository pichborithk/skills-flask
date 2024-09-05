package dev.pichborith.SkillsLabAcademyAPI.mapper;

import dev.pichborith.SkillsLabAcademyAPI.dto.SectionResponse;
import dev.pichborith.SkillsLabAcademyAPI.models.Section;
import org.springframework.stereotype.Service;

@Service
public class SectionMapper {

    public SectionResponse toSectionResponse(Section section) {
        return new SectionResponse(section.getId(), section.getTitle());
    }
}
