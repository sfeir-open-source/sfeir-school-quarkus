# Lab-11 Racer microservice

**Goal** : Implement the racer microservice

**Time** : 30 minutes

Create the new module : 

```shell
mvn io.quarkus:quarkus-maven-plugin:2.16.6.Final:create \
  -DprojectGroupId=com.sfeir.quarkus100 \
  -DprojectArtifactId=rest-racers \
  -DclassName="com.sfeir.quarkus100.racer.RacerResource" \
  -Dpath="api/racers" \
  -Dextensions="quarkus-resteasy-reactive-jackson,quarkus-rest-client-reactive-jackson,smallrye-openapi"
```

Add following classes to the module : 

- In the package **racer.client**
```java
@Schema(description = "The racing character")
public record Character(@NotNull String name, int speed, float acceleration) {
}
```

```java
@Schema(description = "The vehicle used for the race")
public record Vehicle(@NotNull String name, int speed, float acceleration) {
}
```

- In the package **racer** :

```java
import com.sfeir.quarkus100.racer.client.Character;
import com.sfeir.quarkus100.racer.client.Vehicle;
import io.smallrye.common.constraint.NotNull;

public record Racer(@NotNull Character character, @NotNull Vehicle vehicle) {

}
```

```java
package com.sfeir.quarkus100.racer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/racers")
@Produces(APPLICATION_JSON)
public class RacerResource {

    private final RacerService service;

    public RacerResource(RacerService service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response random() {
      return Response.ok(service.random()).build();
    }
}
```

- Now create a **CharacterAPI** interface, the web client for the **/api/character** route.
- Add it a **random()** method that call **/api/character/random** route.
- Do the same for the api **/api/vehicle/random** in a **VehicleAPI** interface.
- Create the **RacerService** that will use previously created web clients to create a random racer in a **random()** method.
- Add the following test in RacerResourceTest
```java
@Test
void random_racer_success() {
    given()
        .when().get("/api/racers/random")
        .then()
        .statusCode(OK.getStatusCode())
        .contentType(APPLICATION_JSON)
        .body("character.name", Is.is(CharacterAPIMock.RANDOM_NAME))
        .body("character.speed", Is.is(CharacterAPIMock.SPEED))
        .body("character.acceleration", Is.is(CharacterAPIMock.ACCELERATION))
        .body("vehicle.name", Is.is(VehicleAPIMock.RANDOM_NAME))
        .body("vehicle.speed", Is.is(VehicleAPIMock.SPEED))
        .body("vehicle.acceleration", Is.is(VehicleAPIMock.ACCELERATION));
}
```
- Create missing web client **mocks** for the test
- Add the fallback dependency
```shell
./mvnw quarkus:add-extension -Dextensions="smallrye-fault-tolerance"
```
- Add **fallback** methods for **CharacterAPI** and **VehicleAPI**
- Close character and vehicle running services to test your fallback
- Add a timeout on the **RacerResource** method
- Test the timeout with a `Thread.sleep()`
- Remove the `Thread.sleep()`


- Add **CharacterClient** and **VehicleClient** 
```java
import io.quarkus.logging.Log;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import java.time.temporal.ChronoUnit;

@ApplicationScoped
public class CharacterClient {

    private final CharactersAPI charactersAPI;

    public CharacterClient(@RestClient CharactersAPI charactersAPI) {
        this.charactersAPI = charactersAPI;
    }
    
    public Character random() {
        Log.info("Call random character");
        return charactersAPI.random();
    }
}
```
```java
import io.quarkus.logging.Log;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import java.time.temporal.ChronoUnit;

@ApplicationScoped
public class VehicleClient {

    private final VehiclesAPI api;

    public VehicleClient(@RestClient VehiclesAPI api) {
        this.api = api;
    }

    public Vehicle random() {
        Log.info("Call random vehicle");
        return api.random();
    }
}
```
- Use those **Client** instead of **API** in the **Service**
- Add **@Retry** on **random()** 
- Call the api to see the retries in action
- Add **@CircuitBreaker** on **random()** with a delay of 10 seconds
- Call the api to see the circuit breaker in action : the **Call random** log should not be displayed.
- Wait 10 seconds to make another call, the log should be displayed again but only once. 

