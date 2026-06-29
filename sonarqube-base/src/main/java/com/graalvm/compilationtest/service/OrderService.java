package com.graalvm.compilationtest.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

    public Mono<String> processOrder(int quantity) {
        if (quantity <= 0) {
            return Mono.just("invalid order");
        }
        return Mono.just("order processed: " + quantity + " items");
    }
}
