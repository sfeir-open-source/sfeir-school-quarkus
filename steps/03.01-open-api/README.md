# Lab 03.01 - Enrich documentation

**Goal** : Implement the following tests in `CharacterResourceTest.java`

**Time** : 20~30 minutes

- Add extension `smallrye-openapi` (if not already installed)

```shell
quarkus extension add smallrye-openapi
# or
./mvnw quarkus:add-extension -Dextensions="smallrye-openapi"
```

- Go to http://localhost:8082/q/openapi
- If you got an error restart your app
  - Hit 'q' in the console to close running app then :

```shell
quarkus dev
# or
./mvnw quarkus:dev
```

- Go to http://localhost:8082/q/dev
- Use annotations to enrich your documentation
  - @Operation
  - @APIResponse
  - @Parameter
  - @Header
  - @Schema
  - For more annotations : [Microprofile annotations](https://github.com/eclipse/microprofile-open-api/blob/master/spec/src/main/asciidoc/microprofile-openapi-spec.asciidoc#annotations)
