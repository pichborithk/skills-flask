package dev.pichborith.SkillsLabAcademyAPI.mapper;

import dev.pichborith.SkillsLabAcademyAPI.dto.LectureResponse;
import dev.pichborith.SkillsLabAcademyAPI.models.Lecture;
import org.springframework.stereotype.Service;

@Service
public class LectureMapper {

    public LectureResponse toLectureResponse(Lecture lecture) {
        return new LectureResponse(lecture.getId(), lecture.getTitle(),
                                   lecture.getLength());
    }
}
