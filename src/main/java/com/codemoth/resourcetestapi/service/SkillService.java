package com.codemoth.resourcetestapi.service;

import com.codemoth.resourcetestapi.domain.Skill;
import com.codemoth.resourcetestapi.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> getSkills() {
        return skillRepository.findAll();
    }

    public Skill getSkill(UUID skillId) {
        return skillRepository.getOne(skillId);
    }

    public void addSkill(Skill skill) {
        skillRepository.save(skill);
    }

    public void updateSkill(UUID skillId, Skill skill) {
        Optional<Skill> skillFromDb = skillRepository.findById(skillId);
        if (skillFromDb.isPresent()) {
            skill.setSkillId(skillFromDb.get().getSkillId());
            skillRepository.save(skill);
        }
    }

    public void deleteSkill(UUID skillId) {
        skillRepository.deleteById(skillId);
    }
}
