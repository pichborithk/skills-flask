package dev.pichborith.SkillsLabAcademyAPI.controllers;

import dev.pichborith.SkillsLabAcademyAPI.dto.LectureRequest;
import dev.pichborith.SkillsLabAcademyAPI.dto.LectureResponse;
import dev.pichborith.SkillsLabAcademyAPI.services.LectureService;
import dev.pichborith.SkillsLabAcademyAPI.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/lectures")
@RequiredArgsConstructor
@CrossOrigin(origins = "${CLIENT_URL}")
public class LectureController {

    private final LectureService lectureService;
    private final UserService userService;

    @PostMapping
    @ResponseBody
    public LectureResponse createLecture(@RequestBody LectureRequest request) {
        var user = userService.getCurrentUserDetails();
        return lectureService.create(user, request);
    }

    @PatchMapping("{lectureId}")
    @ResponseBody
    public LectureResponse updateLecture(@PathVariable int lectureId,
                                         @RequestBody LectureRequest request) {
        var user = userService.getCurrentUserDetails();
        return lectureService.update(user, lectureId, request);
    }
}
