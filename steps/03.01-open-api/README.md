# Lab-0x Enrich documentation

**Goal** : Implement the following tests in ```CharacterResourceTest.java```

**Time** : 20~30 minutes

- Add extension ```smallrye-openapi```
```shell
./mvnw quarkus:add-extension -Dextensions="smallrye-openapi"
```

- Go to http://localhost:8082/q/openapi
- If you got an error restart your app 
  - Hit 'q' in the console to close running app then : 
```shell
./mvnw quarkus:dev
```
- Go to http://localhost:8082/q/dev
- Use annotations to enrich your documentation 
  - @Operation
  - @APIResponse
  - @Parameter
  - @Tag
  - For more annotations : [Microprofile annotations](https://github.com/eclipse/microprofile-open-api/blob/master/spec/src/main/asciidoc/microprofile-openapi-spec.asciidoc#annotations)
