package com.codemoth.resourcetestapi.controller;

import com.codemoth.resourcetestapi.service.WorkerService;
import com.codemoth.resourcetestapi.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.codemoth.resourcetestapi.domain.Worker;

import java.util.List;
import java.util.UUID;

@RestController
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @JsonView(Views.Workers.class)
    @GetMapping("/workers")
    public List<Worker> getWorkers() {
        return workerService.getWorkers();
    }

    @JsonView(Views.Worker.class)
    @GetMapping("/worker/{workerId}")
    public Worker getWorker(@PathVariable UUID workerId) {
        return workerService.getWorker(workerId);
    }

    @PostMapping("/worker")
    public void addWorker(@RequestBody Worker worker) {
        workerService.addWorker(worker);
    }

    @PutMapping("/worker/{workerId}")
    public void updateWorker(@PathVariable UUID workerId, @RequestBody Worker worker) {
        workerService.updateWorker(workerId, worker);
    }

    @DeleteMapping("/worker/{workerId}")
    public void deleteWorker(@PathVariable UUID workerId) {
        workerService.deleteWorker(workerId);
    }

}
