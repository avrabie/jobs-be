package xyz.optimized.jobs;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class JobsRepublicApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobsRepublicApplication.class, args);

    }

    @EventListener(ApplicationReadyEvent.class)
    public void startApp() {

        var webClient = WebClient.create("http://time.jsontest.com/");

        Mono<String> result = webClient.get()
                .retrieve()
                .bodyToMono(String.class);

        result.subscribe(System.out::println);
    }


}
