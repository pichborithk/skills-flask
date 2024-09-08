package dev.pichborith.SkillsLabAcademyAPI.services;

import dev.pichborith.SkillsLabAcademyAPI.dto.CourseRequest;
import dev.pichborith.SkillsLabAcademyAPI.dto.CourseResponse;
import dev.pichborith.SkillsLabAcademyAPI.dto.UserResponse;
import dev.pichborith.SkillsLabAcademyAPI.exceptions.NotFoundException;
import dev.pichborith.SkillsLabAcademyAPI.exceptions.UnauthorizedException;
import dev.pichborith.SkillsLabAcademyAPI.mapper.CourseMapper;
import dev.pichborith.SkillsLabAcademyAPI.mapper.SectionMapper;
import dev.pichborith.SkillsLabAcademyAPI.models.Course;
import dev.pichborith.SkillsLabAcademyAPI.repositories.CourseRepo;
import dev.pichborith.SkillsLabAcademyAPI.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepo courseRepo;
    private final CourseMapper courseMapper;
    private final SectionMapper sectionMapper;
    private final UserRepo userRepo;

    public List<CourseResponse> getAll() {
        return courseRepo.findAll()
                         .stream()
                         .map(courseMapper::toCourseResponse)
                         .toList();
    }

    public CourseResponse getById(int courseId) {
        var course = courseRepo.findByIdWithSections(courseId).orElseThrow(
            () -> new NotFoundException(
                String.format("Course with ID = %d does not exist", courseId)));

        var sections = course.getSections().stream()
                             .map(sectionMapper::toSectionResponse).toList();

        return courseMapper.toCourseResponse(course, sections);
    }

    public List<CourseResponse> getAllByInstructorId(int instructorId) {
        return courseRepo.findAllByInstructorId(instructorId)
                         .stream()
                         .map(courseMapper::toCourseResponse)
                         .toList();
    }

    public Course verifyInstructor(int instructorId, int courseId) {
        var course = courseRepo.findById(courseId)
                               .orElseThrow(() -> new NotFoundException(
                                   String.format(
                                       "Course with ID = %d does not exist",
                                       courseId)));

        if (instructorId == course.getInstructor().getId()) {
            return course;
        }

        return null;
    }

    public CourseResponse create(UserResponse user, CourseRequest request) {
        var instructor = userRepo.findById(user.id())
                          .orElseThrow(() -> new NotFoundException(
                              String.format(
                                  "User with ID = %d does not exist",
                                  user.id())));
        var course = courseMapper.toCourse(request, instructor);

        return courseMapper.toCourseResponse(courseRepo.save(course));
    }

    public CourseResponse update(UserResponse user, int courseId, CourseRequest request) {
        var course = verifyInstructor(user.id(), courseId);
        if (course == null) {
            throw new UnauthorizedException(String.format(
                "Course with ID = %d does not belong to Instructor with ID = %d",
                courseId, user.id()));
        }

        course.setTitle(request.title());
        course.setPrice(request.price());

        return courseMapper.toCourseResponse(courseRepo.save(course));
    }
}
