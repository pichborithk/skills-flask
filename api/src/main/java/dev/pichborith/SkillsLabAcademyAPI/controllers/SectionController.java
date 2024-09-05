package dev.pichborith.SkillsLabAcademyAPI.controllers;

import dev.pichborith.SkillsLabAcademyAPI.dto.SectionResponse;
import dev.pichborith.SkillsLabAcademyAPI.services.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sections")
@RequiredArgsConstructor
public class SectionController {

    private final SectionService sectionService;

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
}

