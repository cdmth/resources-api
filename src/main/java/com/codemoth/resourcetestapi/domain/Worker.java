package com.codemoth.resourcetestapi.domain;

import com.codemoth.resourcetestapi.views.Views;
import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;


@JsonView(Views.Workers.class)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="worker")
@Getter
@Setter
public class Worker {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    @Column(name = "worker_id", unique = true, nullable = false)
    @Type(type="pg-uuid")
    private UUID workerId;

    @JsonView({Views.Workers.class, Views.Worker.class, Views.Skill.class})
    private String firstName;

    @JsonView({Views.Workers.class, Views.Worker.class, Views.Skill.class})
    private String lastName;

    @OneToMany(mappedBy = "worker")
    @JsonView(Views.Worker.class)
    private Set<WorkerSkill> workerSkills = new HashSet<>();

}
