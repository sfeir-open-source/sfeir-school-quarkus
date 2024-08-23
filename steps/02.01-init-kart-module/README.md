# Lab 02.01 - init second microservice

**Goal** Initialize a Quarkus project

**Time** 10~20 minutes

## Steps

- Go to the super-app dir in the last zip
- Use quarkus CLI to create the Quarkus project

```shell
quarkus create app \
  -x resteasy-reactive-jackson quarkus-smallrye-openapi \
  -o=. \
  com.sfeir.quarkus.karts:karts-micro-service

# or

mvn io.quarkus:quarkus-maven-plugin:3.13.3:create \
  -DprojectGroupId=com.sfeir.quarkus \
  -DprojectArtifactId=karts-micro-service \
  -DclassName="com.sfeir.quarkus.karts.KartsResource" \
  -Dpath="api/karts" \
  -Dextensions="resteasy-reactive-jackson,quarkus-smallrye-openapi"
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

- (if you choose `quarkus create app`) rename class `GreetingResource` to `KartsResource` and endpoint `/hello` to `/api/karts`

Call url `http://localhost:8084/api/karts`

```shell
curl http://localhost:8084/api/karts
```
