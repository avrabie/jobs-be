package xyz.optimized.jobs.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import xyz.optimized.jobs.apifirst.model.Job;
import xyz.optimized.jobs.data.JobEntity;
import xyz.optimized.jobs.mappers.JobEntityToJobMapper;
import xyz.optimized.jobs.repo.JobRepo;

@Service
public class JobService {
    private final JobRepo jobRepo;
    private final JobEntityToJobMapper mapper;

    public JobService(JobRepo jobRepo, JobEntityToJobMapper mapper) {
        this.jobRepo = jobRepo;
        this.mapper = mapper;
    }

    public Flux<Job> getAllJobs() {
        return jobRepo.findAll().map(mapper::toJob);
    }

    public Mono<Job> getJobById(String id) {
        return jobRepo
                .findById(id)
                .map(mapper::toJob);
    }
    public Mono<Void> saveJob(Mono<Job> job) {
        Mono<JobEntity> aJob = job.map(mapper::toJobEntity);
        Mono<Void> objectMono = aJob
                .flatMap(jobRepo::save)
                .then();
        return objectMono;
    }
    public Mono<Void> deleteJob(String id) {
        return jobRepo.deleteById(id);
    }
}
