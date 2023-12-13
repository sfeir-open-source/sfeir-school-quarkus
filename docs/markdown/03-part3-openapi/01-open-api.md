<!-- .slide: class="transition bg-pink" -->

# Documenting your API

##==##

<!-- .slide: class="with-code" -->

# OpenAPI with Quarkus

- Extension **smallrye-openapi**
- Accessible on **/q/openapi**

```shell
quarkus extension add smallrye-openapi
# or
./mvnw quarkus:add-extension -Dextensions="smallrye-openapi"
```

##==##

<!-- .slide: class="with-code" -->

# OpenAPI with Quarkus

- Standard : Eclipse MicroProfile OpenAPI
- Basic annotations :
  - @Operation
  - @APIResponse
  - @Parameter
  - @RequestBody
  - @Tag

Reference : [Microprofile annotations](https://github.com/eclipse/microprofile-open-api/blob/master/spec/src/main/asciidoc/microprofile-openapi-spec.asciidoc#annotations)

<!-- .element: class="credits" -->

##==##

<!-- .slide: class="with-code" -->

# OpenAPI with Quarkus - Example

```java
    @Operation(summary = "Get a character by its id")
    @APIResponse(responseCode = "200",
      description = "When the character is found")
    @APIResponse(responseCode = "204",
      description = "When the character is not found")
    @GET
    @Path("/{id}")
    public RestResponse<Character> get(
            @RestPath @Parameter(required = true)  Long id) {
        [...]
    }
```

Reference : [Microprofile annotations](https://github.com/eclipse/microprofile-open-api/blob/master/spec/src/main/asciidoc/microprofile-openapi-spec.asciidoc#annotations)

<!-- .element: class="credits" -->

##==##

<!-- .slide: class="exercice" -->

# Write some documentation

## Lab

[👉 Lab 03.01](https://github.com/sfeir-open-source/sfeir-school-quarkus/blob/main/steps/03.01-open-api/README.md)
