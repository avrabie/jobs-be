package xyz.optimized.jobs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class GreetingsController {

    @GetMapping("/greetings")
    public Flux<String> greetings() {
        return Flux.just("Hello",", ", "World!").delayElements(Duration.ofMillis(500));
    }
}
