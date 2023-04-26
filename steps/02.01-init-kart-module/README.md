# Lab-06 init second microservice

**Goal** Initialize the Quarkus project

**Time** 10~20 minutes

## Steps
- Go to the super-app dir in the last zip
- Use quarkus CLI to create the Quarkus project

```shell
quarkus create app com.sfeir.quarkus100:karts-micro-service --extension="quarkus-resteasy-reactive,resteasy-reactive-jackson" -Dpath="api/karts"
```

- Add the new module in the sfeir-school-quarkus-100 pom.xml

```shell
<modules>
  <module>super-app/characters-micro-service</module>
  <module>super-app/karts-micro-service</module>
</modules>
```

- Launch the app from `karts-micro-service` directory

```shell
cd karts-micro-service
quarkus dev
```

Call url `http://localhost:8080/hello`

```shell
curl http://localhost:8080/hello
```



