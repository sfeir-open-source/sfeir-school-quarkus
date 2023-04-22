<!-- .slide: class="transition bg-pink" -->
# Documenting your API


##==##
<!-- .slide: class="with-code" -->
# OpenAPI with Quarkus

- Extension **smallrye-openapi**
- Accessible on **/q/openapi**

##==##
<!-- .slide: class="with-code" -->
# OpenAPI with Quarkus

- Eclipse MicroProfile OpenAPI
- Basic annotations : 
  - @Operation
  - @APIResponse
  - @Parameter
  - @RequestBody
  - @Tag

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

Reference : <br>
[Microprofile annotations](https://github.com/eclipse/microprofile-open-api/blob/master/spec/src/main/asciidoc/microprofile-openapi-spec.asciidoc#annotations)


##==##
<!-- .slide: class="exercice" -->
# Write some documentation
## Lab

[👉 Lab X](https://github.com/sfeir-open-source/sfeir-school-quarkus/blob/speaker/steps/03.01-open-api/README.md)
