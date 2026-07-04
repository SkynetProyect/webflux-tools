package com.graalvm.kafkatest.service;

import reactor.core.publisher.Sinks;
import reactor.kafka.receiver.ReceiverRecord;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import reactor.kafka.receiver.KafkaReceiver;
import reactor.core.publisher.Flux;

/*
Kafka
   │
   ▼
KafkaReceiver
   │
   ▼
EventBus (Sinks.Many)
   │
 ┌─┼──────────────┐
 │ │              │
 ▼ ▼              ▼
ChatService  MapService  NotificationService

*/

@Service
public class KafkaConsumer {

    private final Sinks.Many<ReceiverRecord<String,String>> sink; // ok so sink is like a radio station, its a broadcaster.
    private final KafkaReceiver<String, String> receiver;

    public KafkaConsumer(KafkaReceiver<String, String> receiver){
        this.receiver = receiver;
        this.sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    @PostConstruct
    public void start() {
        receiver.receive()
                .subscribe(this::processEnvelope);  //each .subscribe() to receive() generates a new consumer in kafka, here is only one and send to sink
    }

    void processEnvelope(ReceiverRecord<String, String> envelope) { //logic should not be inside of a @PostConstruct, cause its hard to test

        Sinks.EmitResult result = sink.tryEmitNext(envelope);

        if (result.isFailure()) {
            System.err.println("Radio station Failed to emit: " + result);
            throw new IllegalStateException("Failed to emit");
        }
        System.out.println("Message received: " + envelope);
        envelope.receiverOffset().acknowledge();

    }
            

    public Flux<ReceiverRecord<String,String>> stream() {
        return sink.asFlux(); // this is the method that allows me connect multiple services to just one broadcaster
    }
}