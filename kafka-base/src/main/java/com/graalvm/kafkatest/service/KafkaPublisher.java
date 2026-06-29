package com.graalvm.kafkatest.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;

@Service
public class KafkaPublisher {

    private final KafkaSender<String, String> sender;

    public KafkaPublisher(KafkaSender<String, String> sender){
        this.sender = sender;

    }

    public Mono<Void> send(String message) {

        SenderRecord<String, String, String> envelope =
                SenderRecord.create(
                        new ProducerRecord<>("lenin", message),
                        null);

        return sender.send(Mono.just(envelope))
                .then();
    }
}