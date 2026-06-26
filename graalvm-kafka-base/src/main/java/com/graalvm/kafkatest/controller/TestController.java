package com.graalvm.kafkatest.controller;

import com.graalvm.kafkatest.service.KafkaPublisher;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    private final KafkaPublisher publisher;

    public TestController(KafkaPublisher publisher){
        this.publisher = publisher;
    }

    @GetMapping("/send")
    public Mono<Void> send() {

        return publisher.send("Hello from WebFlux");
    }
}