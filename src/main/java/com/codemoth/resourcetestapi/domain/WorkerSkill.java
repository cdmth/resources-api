package com.codemoth.resourcetestapi.domain;

import com.codemoth.resourcetestapi.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "worker_skills")
public class WorkerSkill implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name="worker_id")
    @JsonView(Views.Skill.class)
    private Worker worker;

    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    @JsonView(Views.Worker.class)
    private Skill skill;

    @Column(name="experience")
    @JsonView({Views.Worker.class, Views.Skill.class})
    private Integer experience;

}
