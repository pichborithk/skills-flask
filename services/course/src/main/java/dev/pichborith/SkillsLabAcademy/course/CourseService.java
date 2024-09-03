package dev.pichborith.SkillsLabAcademy.course;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepo;
    private final CourseMapper courseMapper;

    public List<CourseResponse> getAll() {
        return courseRepo.findAll().stream().map(courseMapper::toCourseResponse)
                         .toList();
    }
}
