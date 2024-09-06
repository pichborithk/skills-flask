package dev.pichborith.SkillsLabAcademyAPI.controllers;

import dev.pichborith.SkillsLabAcademyAPI.dto.CourseResponse;
import dev.pichborith.SkillsLabAcademyAPI.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
@RequiredArgsConstructor
@CrossOrigin(origins = "${CLIENT_URL}")
public class CourseController {

    private final CourseService courseService;

    @ResponseBody
    @GetMapping
    public List<CourseResponse> getAllCourses() {
        return courseService.getAll();
    }

    @ResponseBody
    @GetMapping("{courseId}")
    public CourseResponse getCourseById(@PathVariable int courseId) {
        return courseService.getById(courseId);
    }
}
