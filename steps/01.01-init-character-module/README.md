# Lab-01 Check prerequisites

**Goal** Initialize the Quarkus project

**Time** 10~20 minutes

## Steps

- Download [startup archive](sfeir-school-quarkus-100.zip) and unzip it
- Go to the sfeir-school-quarkus-100 directory
- Use maven to create the Quarkus project
```shell
mvn io.quarkus:quarkus-maven-plugin:2.16.5.Final:create \
     -DprojectGroupId=com.sfeir.quarkus100 \
     -DprojectArtifactId=characters-micro-service \
     -DclassName="com.sfeir.quarkus100.CharactersResource" \
     -Dpath="api/characters" \
     -Dextensions="resteasy-reactive-jackson"
```

- Add the new module in the sfeir-school-quarkus-100 pom.xml

```shell
<modules>
  <module>super-app/characters-micro-service</module>
</modules>
```

- Launch the app from `characters-micro-service` directory

```shell
cd characters-micro-service
./mvnw quarkus:dev
```

Call url `http://localhost:8080/api/characters`

```shell
curl http://localhost:8080/api/characters
```



