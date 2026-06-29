package com.graalvm.compilationtest.unitary.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import reactor.test.StepVerifier;
//import com.graalvm.compilationtest.base.BaseOrderRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.graalvm.compilationtest.service.OrderService;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @InjectMocks
    OrderService orderService;

    @Test
    void whenQuantityIsPositive_thenReturnsProcessed() {
        StepVerifier.create(orderService.processOrder(5))
            .expectNext("order processed: 5 items")
            .verifyComplete();
    }

    @Test
    void whenQuantityIsZero_thenReturnsInvalid() {
        StepVerifier.create(orderService.processOrder(0))
            .expectNext("invalid order")
            .verifyComplete();
    }

    @Test
    void whenQuantityIsNegative_thenReturnsInvalid() {
        StepVerifier.create(orderService.processOrder(-1))
            .expectNext("invalid order")
            .verifyComplete();
    }
}