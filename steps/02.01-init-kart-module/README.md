# Lab-06 init second microservice

**Goal** Initialize the Quarkus project

**Time** 10~20 minutes

## Steps
- Go to the super-app dir in the last zip
- Use quarkus CLI to create the Quarkus project

```shell
mvn io.quarkus:quarkus-maven-plugin:3.0.1.Final:create \
     -DprojectGroupId=com.sfeir.quarkus100 \
     -DprojectArtifactId=karts-micro-service \
     -DclassName="com.sfeir.quarkus100.KartsResource" \
     -Dpath="api/karts" \
     -Dextensions="resteasy-reactive-jackson"
    ```

- Add the new module in the sfeir-school-quarkus-100 pom.xml

```shell
<modules>
  <module>super-app/characters-micro-service</module>
  <module>super-app/karts-micro-service</module>
</modules>
```

- add new line on application.properties of karts-micro-service

```shell
quarkus.http.port=8084
```

- Launch the app from `karts-micro-service` directory

```shell
cd karts-micro-service
quarkus dev
```

Call url `http://localhost:8084/api/karts`

```shell
curl http://localhost:8084/api/karts
```



