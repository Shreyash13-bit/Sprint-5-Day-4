package com.example.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.time.Instant;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import reactor.core.publisher.Mono;

@Configuration
public class RouteConfig {

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return route(GET("/hello"), req -> ok().body(Mono.just("Hello Functional"), String.class))
             .andRoute(GET("/time"), req -> ok().body(Mono.just(Instant.now().toString()), String.class));
    }
}
