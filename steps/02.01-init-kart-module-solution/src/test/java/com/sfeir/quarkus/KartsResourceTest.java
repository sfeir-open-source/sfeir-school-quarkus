package com.sfeir.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class KartsResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/api/karts")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive"));
    }

}
