package com.sfeir.quarkus100;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.*;
import static javax.ws.rs.core.Response.*;
import static javax.ws.rs.core.Response.Status.*;
import static org.apache.http.entity.ContentType.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class CharactersResourceTest {

    public static final String API_CHARACTERS = "/api/characters";

    @Test
    public void testHelloEndpoint() {
        given().basePath(API_CHARACTERS)
               .when().get("/hello")
               .then()
               .statusCode(200)
               .body(is("Hello from RESTEasy Reactive Quarkus"));
    }

    @Test
    public void random_always_returns_something() {
        given().basePath(API_CHARACTERS)
               .when().get("/random")
               .then()
               .statusCode(OK.getStatusCode())
               .body(is(not(emptyString())));
    }

    @Test
    public void get_verify_name_and_type_for_character_1() {
        given().basePath(API_CHARACTERS)
               .when().get("/1")
               .then()
               .contentType(ContentType.JSON)
               .body("name", equalTo("Baby Luigi"))
               .body("type", equalTo(CharacterType.FEATHERWEIGHT.toString()));
    }

    @Test
    public void get_status_code_is_204_when_not_exists() {
        given().basePath(API_CHARACTERS)
               .when().get("/1000")
               .then()
               .statusCode(NO_CONTENT.getStatusCode());
    }

    @Test
    @Order(Integer.MAX_VALUE)
    public void delete_status_code_is_204_then_get_returns_204() {
        given().basePath(API_CHARACTERS)
               .when().delete("/1")
               .then()
               .statusCode(NO_CONTENT.getStatusCode());

        given().basePath(API_CHARACTERS)
               .when().get("/1")
               .then()
               .statusCode(Status.NO_CONTENT.getStatusCode());
    }

    @Test
    public void create_status_is_201_and_location_contains_api_base_path() {

        Character toCreate = new Character();
        toCreate.name = "newCharacter";
        toCreate.speed = 10;
        toCreate.acceleration = 1;
        toCreate.type = CharacterType.HEAVY;

        given().basePath(API_CHARACTERS)
               .body(toCreate)
               .header(CONTENT_TYPE, "application/json")
               .header(ACCEPT, "application/json")
               .post()
               .then()
               .header(HttpHeaders.LOCATION, loc -> containsString(API_CHARACTERS))
               .statusCode(CREATED.getStatusCode());
    }

    @Test
    public void update_status_is_200_and_contains_new_character() {

        Character toUpdate = new Character();

        toUpdate.id = 2L;
        toUpdate.name = "updatedCharacter";
        toUpdate.speed = 10;
        toUpdate.acceleration = 1;
        toUpdate.type = CharacterType.HEAVY;

        given().basePath(API_CHARACTERS)
               .body(toUpdate)
               .header(CONTENT_TYPE, "application/json")
               .header(ACCEPT, "application/json")
               .put()
               .then()
               .statusCode(OK.getStatusCode())
               .body("name", is("updatedCharacter"))
        ;

    }


}