package xyz.optimized.jobs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import xyz.optimized.jobs.apifirst.api.JobsApi;
import xyz.optimized.jobs.apifirst.model.Job;
import xyz.optimized.jobs.data.JobEntity;
import xyz.optimized.jobs.service.JobService;

@RestController
public class JobsController implements JobsApi {
    private final JobService jobService;

    public JobsController(JobService jobService) {
        this.jobService = jobService;
    }

    @Override
    public Mono<ResponseEntity<Flux<Job>>> getjobs(ServerWebExchange exchange) {
        Flux<Job> allJobs = jobService.getAllJobs();

        return Mono.just(ResponseEntity.ok(allJobs))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @Override
    public Mono<ResponseEntity<Job>> getjob(String id, ServerWebExchange exchange) {
        return jobService.getJobById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @Override
    public Mono<ResponseEntity<Void>> createjob(Mono<Job> job, ServerWebExchange exchange) {
        Mono<Void> jobEntity = jobService.saveJob(job);

        return jobEntity
                .<ResponseEntity<Void>>map(jobEntity1 -> ResponseEntity.ok().build())
                .onErrorReturn(ResponseEntity.badRequest().build())
                ;


    }
}
