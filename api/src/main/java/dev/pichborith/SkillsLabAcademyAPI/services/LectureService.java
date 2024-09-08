package dev.pichborith.SkillsLabAcademyAPI.services;

import dev.pichborith.SkillsLabAcademyAPI.dto.LectureRequest;
import dev.pichborith.SkillsLabAcademyAPI.dto.LectureResponse;
import dev.pichborith.SkillsLabAcademyAPI.dto.UserResponse;
import dev.pichborith.SkillsLabAcademyAPI.exceptions.NotFoundException;
import dev.pichborith.SkillsLabAcademyAPI.exceptions.UnauthorizedException;
import dev.pichborith.SkillsLabAcademyAPI.mapper.LectureMapper;
import dev.pichborith.SkillsLabAcademyAPI.repositories.LectureRepo;
import dev.pichborith.SkillsLabAcademyAPI.repositories.SectionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final SectionRepo sectionRepo;
    private final LectureRepo lectureRepo;
    private final LectureMapper lectureMapper;

    public LectureResponse create(UserResponse user, LectureRequest request) {
        var sectionId = request.sectionId();
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

        var section = sectionRepo.findById(sectionId).orElseThrow(
            () -> new NotFoundException(String.format(
                "Section with ID = %d does not exist",
                sectionId)));

        var lecture = lectureMapper.toLecture(request, section);

        return lectureMapper.toLectureResponse(lectureRepo.save(lecture));
    }

    public LectureResponse update(UserResponse user, int lectureId,
                                  LectureRequest request) {
        var sectionId = request.sectionId();
        var lectureView = lectureRepo.findViewById(lectureId)
                                     .orElseThrow(() -> new NotFoundException(
                                         String.format(
                                             "Lecture with ID = %d does not exist",
                                             lectureId)));

        if (sectionId != lectureView.getSectionId()) {
            throw new UnauthorizedException(String.format(
                "Lecture with ID = %d does not belong to Section with ID = %d",
                lectureId, sectionId));
        }

        if (user.id() != lectureView.getInstructorId()) {
            throw new UnauthorizedException(String.format(
                "Lecture with ID = %d does not belong to Instructor with ID = %d",
                lectureId, user.id()));
        }

        var lecture = lectureRepo.findById(lectureId)
                                 .orElseThrow(() -> new NotFoundException(
                                     String.format(
                                         "Lecture with ID = %d does not exist",
                                         lectureId)));

        lecture.setSequence(request.sequence());
        lecture.setTitle(request.title());
        lecture.setLength(request.length());

        return lectureMapper.toLectureResponse(lectureRepo.save(lecture));
    }
}
