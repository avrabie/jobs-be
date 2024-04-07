package xyz.optimized.jobs.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import xyz.optimized.jobs.apifirst.model.Job;
import xyz.optimized.jobs.data.JobEntity;
import xyz.optimized.jobs.mappers.JobEntityToJobMapper;
import xyz.optimized.jobs.repo.JobRepo;

import java.util.OptionalInt;

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
        int jobId = getJobId(id);
        return jobRepo
                .findById(jobId)
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
        return jobRepo.deleteById(getJobId(id));
    }

    public Mono<Void> updateJob(String id, Mono<Job> job) {
        return jobRepo.findById(getJobId(id))
                .flatMap(jobEntity -> job.map(mapper::toJobEntity)
                        .doOnNext(jobEntity::update)
                        .then(jobRepo.save(jobEntity)))
                .then();
    }

    // helper methods
    private static int getJobId(String id) {
        return OptionalInt.of(Integer.parseInt(id))
                .orElseThrow(() -> new IllegalArgumentException("Invalid id"));

    }
}
