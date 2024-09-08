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
    private final CourseRepo courseRepo;

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
        var course = courseRepo.findById(courseId)
                               .orElseThrow(() -> new NotFoundException(
                                   String.format(
                                       "Course with ID = %d does not exist",
                                       courseId)));

        if (user.id() != course.getInstructor().getId()) {
            throw new UnauthorizedException(String.format(
                "Course with ID = %d does not belong to Instructor with ID = %d",
                courseId, user.id()));
        }


        var section = sectionRepo.save(
            sectionMapper.toSection(request, course));

        return sectionMapper.toSectionResponse(section);
    }

    public SectionResponse update(UserResponse user, int sectionId,
                                  SectionRequest request) {
        var sectionView = sectionRepo.findViewById(sectionId)
                                     .orElseThrow(() -> new NotFoundException(
                                         String.format(
                                             "Section with ID = %d does not exist",
                                             sectionId)));

        var courseId = request.courseId();
        if (courseId != sectionView.getCourseId()) {
            throw new UnauthorizedException(String.format(
                "Section with ID = %d does not belong to Course with ID = %d",
                sectionId, courseId));
        }

        if (user.id() != sectionView.getInstructorId()) {
            throw new UnauthorizedException(String.format(
                "Section with ID = %d does not belong to Instructor with ID = %d",
                sectionId, user.id()));
        }

        var section = sectionRepo.findById(sectionId)
                                 .orElseThrow(() -> new NotFoundException(
                                     String.format(
                                         "Section with ID = %d does not exist",
                                         sectionId)));

        section.setSequence(request.sequence());
        section.setTitle(request.title());

        return sectionMapper.toSectionResponse(sectionRepo.save(section));
    }

    public void delete(UserResponse user, int sectionId) {

        var sectionView = sectionRepo.findViewById(sectionId)
                                     .orElseThrow(() -> new NotFoundException(
                                         String.format(
                                             "Section with ID = %d does not exist",
                                             sectionId)));

        if (user.id() != sectionView.getInstructorId()) {
            throw new UnauthorizedException(String.format(
                "Section with ID = %d does not belong to Instructor with ID = %d",
                sectionId, user.id()));
        }

        sectionRepo.deleteById(sectionId);
    }
}
