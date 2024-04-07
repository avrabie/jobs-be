package xyz.optimized.jobs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import xyz.optimized.jobs.apifirst.model.Job;
import xyz.optimized.jobs.data.JobEntity;
import xyz.optimized.jobs.mappers.JobEntityToJobMapper;
import xyz.optimized.jobs.repo.JobRepo;

import java.time.Duration;

@RestController
public class GreetingsController {
    private final JobRepo jobRepo;

    public GreetingsController(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    @GetMapping("/greetings")
    public Flux<String> greetings() {
        return Flux.just("Hello",", ", "World!").delayElements(Duration.ofMillis(500));
    }

    @GetMapping("/iaka")
    public Flux<JobEntity> iaka() {
        return jobRepo.findAll();
    }

    @GetMapping("/transformation")
    public Flux<Job> transformation() {
        JobEntityToJobMapper instance = JobEntityToJobMapper.INSTANCE;
        Flux<JobEntity> all = jobRepo.findAll();
        return all.map(instance::toJob);
    }

}
