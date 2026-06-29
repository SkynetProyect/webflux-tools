package com.graalvm.compilationtest.repository;

import com.graalvm.compilationtest.model.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface OrderRepository extends ReactiveCrudRepository<Order, Long> {
    
}