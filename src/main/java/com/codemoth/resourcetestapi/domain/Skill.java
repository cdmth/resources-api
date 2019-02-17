package com.codemoth.resourcetestapi.domain;

import com.codemoth.resourcetestapi.views.Views;
import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@JsonView(Views.Skills.class)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="skill")
@Getter
@Setter
public class Skill {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    @Column(name = "skill_id", unique = true, nullable = false)
    @Type(type="pg-uuid")
    private UUID skillId;

    @NotNull
    @JsonView({Views.Skills.class, Views.Worker.class, Views.Skill.class})
    private String name;

    @JsonView(Views.Skill.class)
    @OneToMany(mappedBy = "skill")
    private Set<WorkerSkill> workerSkills = new HashSet<>();

}
