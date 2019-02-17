package com.codemoth.resourcetestapi.service;

import com.codemoth.resourcetestapi.domain.Worker;
import com.codemoth.resourcetestapi.domain.WorkerSkill;
import com.codemoth.resourcetestapi.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    public List<Worker> getWorkers() {
        return workerRepository.findAll();
    }

    public Worker getWorker(UUID workerId) {
        return workerRepository.findById(workerId).get();
    }

    public void addWorker(Worker worker) {
        workerRepository.save(worker);
    }

    public void updateWorker(UUID workerId, Worker worker) {
        Optional<Worker> workerFromDb = workerRepository.findById(workerId);
        if (workerFromDb.isPresent()) {
            worker.setWorkerId(workerFromDb.get().getWorkerId());
            workerRepository.save(worker);
        }
    }

    public void deleteWorker(UUID workerId) {
        workerRepository.deleteById(workerId);
    }

}
