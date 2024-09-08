package dev.pichborith.SkillsLabAcademyAPI.controllers;

import dev.pichborith.SkillsLabAcademyAPI.dto.SectionRequest;
import dev.pichborith.SkillsLabAcademyAPI.dto.SectionResponse;
import dev.pichborith.SkillsLabAcademyAPI.services.SectionService;
import dev.pichborith.SkillsLabAcademyAPI.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sections")
@RequiredArgsConstructor
@CrossOrigin(origins = "${CLIENT_URL}")
public class SectionController {

    private final SectionService sectionService;
    private final UserService userService;

    @GetMapping
    @ResponseBody
    public List<SectionResponse> getAllSections() {
        return sectionService.getAll();
    }

    @GetMapping("{sectionId}")
    @ResponseBody
    public SectionResponse getSectionById(@PathVariable int sectionId) {
        return sectionService.getById(sectionId);
    }

    @PostMapping
    @ResponseBody
    public SectionResponse createSection(@RequestBody SectionRequest request) {
        var user = userService.getCurrentUserDetails();

        return sectionService.create(user, request);
    }

    @PatchMapping("{sectionId}")
    @ResponseBody
    public SectionResponse updateSection(@PathVariable int sectionId,
                                         @RequestBody SectionRequest request) {
        var user = userService.getCurrentUserDetails();

        return sectionService.update(user, sectionId, request);
    }
}


