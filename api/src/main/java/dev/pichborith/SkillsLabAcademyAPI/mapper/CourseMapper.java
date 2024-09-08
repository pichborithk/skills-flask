package dev.pichborith.SkillsLabAcademyAPI.mapper;

import dev.pichborith.SkillsLabAcademyAPI.dto.CourseRequest;
import dev.pichborith.SkillsLabAcademyAPI.dto.CourseResponse;
import dev.pichborith.SkillsLabAcademyAPI.dto.SectionResponse;
import dev.pichborith.SkillsLabAcademyAPI.dto.UserResponse;
import dev.pichborith.SkillsLabAcademyAPI.models.Course;
import dev.pichborith.SkillsLabAcademyAPI.models.User;
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
                                          course.getInstructor().getUsername(), course.getInstructor().getRole());
        return new CourseResponse(course.getId(), course.getTitle(),
                                  course.getPrice(), instructor, sections);
    }

    public Course toCourse(CourseRequest request, User instructor) {
        return new Course(0, request.title(), request.price(), instructor, new ArrayList<>());
    }
}
