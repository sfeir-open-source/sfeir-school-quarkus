package com.sfeir.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class CharactersResourceTest {
    @Test
    void testGetCharactersEndpoint() {
        given()
          .when().get("/api/characters")
          .then()
             .statusCode(200)
             .body(is("{ \"name\": \"Luigi\"  }"));
    }

}
