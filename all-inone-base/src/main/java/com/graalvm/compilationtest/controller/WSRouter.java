package com.graalvm.websocket.router;

import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;

@Component
public class WSRouter implements org.springframework.web.reactive.socket.WebSocketHandler {

    private final ObjectMapper mapper;

    public WSRouter(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        return session.send(
        session.receive()
            .flatMap(msg -> {
                try {
                    JsonNode node = mapper.readTree(msg.getPayloadAsText()); //this creates a dict from json, no reflection used.
                    String type = node.get("type").asText(); 

                    return switch (type) {
                        case "PING"  -> Mono.just(session.textMessage("PONG"));
                        case "ORDER" -> Mono.just(session.textMessage("Order processed: " + node.get("data")));
                        case "CHAT"  -> Mono.just(session.textMessage("Message received"));
                        default      -> Mono.just(session.textMessage("Unknown type: " + type));
                    };
                } catch (Exception e) {
                    return Mono.just(session.textMessage("Invalid JSON"));
                }
            })
        );
    }
}