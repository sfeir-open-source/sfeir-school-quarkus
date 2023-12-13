package com.sfeir.quarkus.racer;

import com.sfeir.quarkus.racer.client.Character;
import com.sfeir.quarkus.racer.client.CharacterAPI;
import com.sfeir.quarkus.racer.client.Vehicle;
import com.sfeir.quarkus.racer.client.VehiclesAPI;
import io.quarkus.test.Mock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static jakarta.ws.rs.core.Response.Status.OK;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class RacerResourceTest {
  @Test
  void random_racer_success() {
    given()
      .when().get("/api/racers/random")
      .then()
      .statusCode(OK.getStatusCode())
      .contentType(MediaType.APPLICATION_JSON)
      .body("character.name", Is.is(CharacterAPIMock.RANDOM_NAME))
      .body("character.speed", Is.is(CharacterAPIMock.SPEED))
      .body("character.acceleration", Is.is(CharacterAPIMock.ACCELERATION))
      .body("vehicle.name", Is.is(VehicleAPIMock.RANDOM_NAME))
      .body("vehicle.speed", Is.is(VehicleAPIMock.SPEED))
      .body("vehicle.acceleration", Is.is(VehicleAPIMock.ACCELERATION));
  }

  @Mock
  @RestClient
  static class CharacterAPIMock implements CharacterAPI {
    static String RANDOM_NAME = "character";
    static int SPEED = 1;
    static float ACCELERATION = 2.5f;

    @Override
    public Character random() {
      return new Character(RANDOM_NAME, SPEED, ACCELERATION);
    }
  }

  @Mock
  @RestClient
  static class VehicleAPIMock implements VehiclesAPI  {
    static String RANDOM_NAME = "vehicule";
    static int SPEED = 2;
    static float ACCELERATION = 3.5f;

    @Override
    public Vehicle random() {
      return new Vehicle(RANDOM_NAME, SPEED, ACCELERATION);
    }
  }
}
