<!-- .slide: class="with-code" -->

# Testing the application

```java
@QuarkusTest
public class CharactersResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/api/characters")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive"));
    }
}
```

##==##

<!-- .slide: class="with-code" -->

# Testing the application

- **@QuarkusTest**
- RestAssured
  - given()
  - when()
  - then()
  - get(), post(), put(), delete()
  - body()
  - header()
  - contentType()

##==##

<!-- .slide: class="exercice" -->

# Complete test Suite

## Lab

[👉 Lab 01.06](https://github.com/sfeir-open-source/sfeir-school-quarkus/blob/main/steps/01.06-test-application/README.md)
