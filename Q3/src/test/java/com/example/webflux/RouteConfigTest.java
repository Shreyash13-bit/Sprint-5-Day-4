package com.example.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest
@Import(RouteConfig.class)
public class RouteConfigTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testHelloRoute() {
        webTestClient.get().uri("/hello")
            .exchange()
            .expectStatus().isOk()
            .expectBody(String.class)
            .isEqualTo("Hello Functional");
    }

    @Test
    void testTimeRoute() {
        webTestClient.get().uri("/time")
            .exchange()
            .expectStatus().isOk()
            .expectBody(String.class)
            .value(time -> assert !time.isEmpty());
    }
}
