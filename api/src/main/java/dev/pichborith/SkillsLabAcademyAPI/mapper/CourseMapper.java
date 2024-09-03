package dev.pichborith.SkillsLabAcademyAPI.mapper;

import dev.pichborith.SkillsLabAcademyAPI.dto.CourseResponse;
import dev.pichborith.SkillsLabAcademyAPI.models.Course;
import org.springframework.stereotype.Service;

@Service
public class CourseMapper {

    public CourseResponse toCourseResponse(Course course) {
        return new CourseResponse(course.getId(), course.getTitle());
    }
}
