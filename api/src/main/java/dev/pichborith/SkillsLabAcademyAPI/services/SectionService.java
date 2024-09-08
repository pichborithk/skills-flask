package dev.pichborith.SkillsLabAcademyAPI.services;

import dev.pichborith.SkillsLabAcademyAPI.dto.SectionRequest;
import dev.pichborith.SkillsLabAcademyAPI.dto.SectionResponse;
import dev.pichborith.SkillsLabAcademyAPI.dto.UserResponse;
import dev.pichborith.SkillsLabAcademyAPI.exceptions.NotFoundException;
import dev.pichborith.SkillsLabAcademyAPI.exceptions.UnauthorizedException;
import dev.pichborith.SkillsLabAcademyAPI.mapper.LectureMapper;
import dev.pichborith.SkillsLabAcademyAPI.mapper.SectionMapper;
import dev.pichborith.SkillsLabAcademyAPI.repositories.CourseRepo;
import dev.pichborith.SkillsLabAcademyAPI.repositories.SectionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SectionService {

    private final SectionRepo sectionRepo;
    private final SectionMapper sectionMapper;
    private final LectureMapper lectureMapper;
    private final CourseService courseService;

    public List<SectionResponse> getAll() {

        return sectionRepo.findAll()
                          .stream()
                          .map(sectionMapper::toSectionResponse)
                          .toList();
    }

    public SectionResponse getById(int sectionId) {
        var section = sectionRepo.findByIdWithLectures(sectionId)
                                 .orElseThrow(() -> new NotFoundException(
                                     String.format(
                                         "Section with ID = %d does not exist",
                                         sectionId)));

        var lectures = section.getLectures().stream()
                              .map(lectureMapper::toLectureResponse).toList();

        return sectionMapper.toSectionResponse(section, lectures);
    }

    public SectionResponse create(UserResponse user, SectionRequest request) {
        var courseId = request.courseId();
        var course = courseService.verifyInstructor(user.id(), courseId);
        if (course == null) {
            throw new UnauthorizedException(String.format(
                "Course with ID = %d does not belong to Instructor with ID = %d",
                courseId, user.id()));
        }
        var section = sectionRepo.save(sectionMapper.toSection(request, course));

        return sectionMapper.toSectionResponse(section);
    }

}
