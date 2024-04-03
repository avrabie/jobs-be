package xyz.optimized.jobs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import xyz.optimized.jobs.apifirst.api.JobsApi;
import xyz.optimized.jobs.apifirst.model.Job;

@RestController
public class JobsController implements JobsApi {

    @Override
    public Mono<ResponseEntity<Flux<Job>>> getjobs(ServerWebExchange exchange) {
        Job job1 = new Job()
                .id("1")
                .title("Software Engineer").description("Develop software applications").location("Remote");
        return Mono.just(ResponseEntity.ok(Flux.just(job1)));
//        return JobsApi.super.getjobs(exchange);
    }
}
