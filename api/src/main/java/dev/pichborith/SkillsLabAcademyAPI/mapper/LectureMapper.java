package dev.pichborith.SkillsLabAcademyAPI.mapper;

import dev.pichborith.SkillsLabAcademyAPI.dto.LectureRequest;
import dev.pichborith.SkillsLabAcademyAPI.dto.LectureResponse;
import dev.pichborith.SkillsLabAcademyAPI.models.Lecture;
import dev.pichborith.SkillsLabAcademyAPI.models.Section;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LectureMapper {

    public LectureResponse toLectureResponse(Lecture lecture) {
        return new LectureResponse(lecture.getId(), lecture.getSequence(), lecture.getTitle(),
                                   lecture.getLength());
    }

    public Lecture toLecture(LectureRequest request, Section section) {
        return new Lecture(0, request.sequence(), request.title(),
                           request.length(), section);
    }
}
