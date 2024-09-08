package dev.pichborith.SkillsLabAcademyAPI.controllers;

import dev.pichborith.SkillsLabAcademyAPI.dto.CourseRequest;
import dev.pichborith.SkillsLabAcademyAPI.dto.CourseResponse;
import dev.pichborith.SkillsLabAcademyAPI.services.CourseService;
import dev.pichborith.SkillsLabAcademyAPI.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
@RequiredArgsConstructor
@CrossOrigin(origins = "${CLIENT_URL}")
public class CourseController {

    private final CourseService courseService;
    private final UserService userService;

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

    @ResponseBody
    @GetMapping("instructor/{instructorId}")
    public List<CourseResponse> getCoursesByInstructorId(@PathVariable int instructorId) {
        return courseService.getAllByInstructorId(instructorId);
    }

    @ResponseBody
    @PostMapping()
    public CourseResponse createCourse(@RequestBody CourseRequest request) {
        var user = userService.getCurrentUserDetails();
        return courseService.create(user, request);
    }
}
