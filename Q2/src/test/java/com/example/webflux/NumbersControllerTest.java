package com.example.webflux;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.test.StepVerifier;

@WebFluxTest(NumbersController.class)
public class NumbersControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testStreamNumbers() {
        webTestClient.get().uri("/numbers")
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType("text/event-stream")
            .returnResult(Integer.class)
            .getResponseBody()
            .as(StepVerifier::create)
            .expectNext(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            .verifyComplete();
    }
}
