package com.graalvm.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import org.springframework.web.util.pattern.PathPatternParser;
import org.springframework.web.reactive.HandlerMapping;
import java.util.HashMap;
import java.util.Map;

import com.graalvm.websocket.router.WSRouter;

@Configuration
public class WebSocketConfig {

    @Bean
    public HandlerMapping handlerMapping(WSRouter handler) {
        Map<String, WebSocketHandler> map = new HashMap<>();
        map.put("/ws", handler); // si requiero mas routers los agrego aqui al map, estos deben entrar como parametros en el constructor de este metodo

        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setUrlMap(map);
        mapping.setOrder(-1); // must be high priority
        return mapping;
    }

    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {
        return new WebSocketHandlerAdapter();
    }
}