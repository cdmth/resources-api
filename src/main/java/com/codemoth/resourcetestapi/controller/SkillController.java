package com.codemoth.resourcetestapi.controller;

import com.codemoth.resourcetestapi.domain.Skill;
import com.codemoth.resourcetestapi.service.SkillService;
import com.codemoth.resourcetestapi.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class SkillController {

    @Autowired
    private SkillService skillService;

    @JsonView(Views.Skills.class)
    @GetMapping("/skills")
    public List<Skill> getSkills() {
        return skillService.getSkills();
    }

    @JsonView(Views.Skill.class)
    @GetMapping("/skill/{skillId}")
    public Skill getSkill(@PathVariable UUID skillId) {
        return skillService.getSkill(skillId);
    }

    @PostMapping("/skill")
    public void addSkill(@RequestBody Skill skill) {
        skillService.addSkill(skill);
    }

    @PutMapping("/skill/{skillId}")
    public void updateSkill(@PathVariable UUID skillId, @RequestBody Skill skill) {
        skillService.updateSkill(skillId, skill);
    }

    @DeleteMapping("/skill/{skillId}")
    public void deleteSkill(@PathVariable UUID skillId) {
        skillService.deleteSkill(skillId);
    }
}
