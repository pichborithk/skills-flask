package dev.pichborith.SkillsLabAcademyAPI.mapper;

import dev.pichborith.SkillsLabAcademyAPI.dto.CourseResponse;
import dev.pichborith.SkillsLabAcademyAPI.dto.SectionResponse;
import dev.pichborith.SkillsLabAcademyAPI.dto.UserResponse;
import dev.pichborith.SkillsLabAcademyAPI.models.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseMapper {

    public CourseResponse toCourseResponse(Course course) {
        return toCourseResponse(course, new ArrayList<>());
    }

    public CourseResponse toCourseResponse(Course course, List<SectionResponse> sections) {
        var instructor = new UserResponse(course.getInstructor().getId(),
                                          course.getInstructor().getUsername());
        return new CourseResponse(course.getId(), course.getTitle(),
                                  course.getPrice(), instructor, sections);
    }
}
