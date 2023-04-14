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

[👉 Lab 5](https://github.com/sfeir-open-source/sfeir-school-quarkus/blob/speaker/steps/01.09-test-application/README.md)


