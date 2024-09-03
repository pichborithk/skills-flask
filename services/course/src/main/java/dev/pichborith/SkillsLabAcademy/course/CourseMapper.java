package dev.pichborith.SkillsLabAcademy.course;

import org.springframework.stereotype.Service;

@Service
public class CourseMapper {

    public CourseResponse toCourseResponse(Course course) {
        return new CourseResponse(course.getId(), course.getTitle(),
                                  course.getPrice(), null);
    }
}
