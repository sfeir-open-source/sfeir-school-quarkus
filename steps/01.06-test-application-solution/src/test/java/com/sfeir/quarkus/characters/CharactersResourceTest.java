package com.sfeir.quarkus.characters;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.ws.rs.core.HttpHeaders;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.HttpHeaders.ACCEPT;
import static jakarta.ws.rs.core.HttpHeaders.CONTENT_TYPE;
import static jakarta.ws.rs.core.Response.Status;
import static jakarta.ws.rs.core.Response.Status.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.*;

@QuarkusTest
class CharactersResourceTest {
  public static final String API_CHARACTERS = "/api/characters";

  @Test
  public void get_all_returns_something() {
    given().basePath(API_CHARACTERS)
      .when().get()
      .then()
      .statusCode(OK.getStatusCode())
    ;
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
  public void create_status_is_201_and_location_header_contains_api_base_path() {

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

    toUpdate.id = 51L;
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
