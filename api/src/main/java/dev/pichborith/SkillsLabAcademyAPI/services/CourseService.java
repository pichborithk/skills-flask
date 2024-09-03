package dev.pichborith.SkillsLabAcademyAPI.services;

import dev.pichborith.SkillsLabAcademyAPI.dto.CourseResponse;
import dev.pichborith.SkillsLabAcademyAPI.mapper.CourseMapper;
import dev.pichborith.SkillsLabAcademyAPI.repositories.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepo courseRepo;
    private final CourseMapper courseMapper;

    public List<CourseResponse> getAll() {
        return courseRepo.findAll()
                         .stream()
                         .map(courseMapper::toCourseResponse)
                         .toList();
    }
}
