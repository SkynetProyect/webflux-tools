package com.graalvm.compilationtest.service;

import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

    private final Tracer tracer;

    public OrderService(Tracer tracer) {
        this.tracer = tracer;
    }

    public Mono<Integer> processOrder(int quantity) {
        Span span = tracer.nextSpan().name("order.process").start();
        return Mono.just(quantity)
            .doFinally(signalType -> span.end());
    }
}