# Lab 01.01 - Init a quakus project

**Goal** Initialize a Quarkus project

**Time** 10~20 minutes

## Steps

- Use https://code.quarkus.io to create the Quarkus project

  - Quarkus LTS (3.8)
  - Group = "com.sfeir.quarkus"
  - Artifact = "characters-micro-service"
  - Build Tool = Maven
  - Java Version = 17
  - Starter Code = Yes
  - add "RESTEasy Reactive Jackson [quarkus-resteasy-reactive-jackson]" extension

- Launch the app from `characters-micro-service` directory

```shell
cd characters-micro-service
quarkus dev
# or
./mvnw quarkus:dev
```

Open `http://localhost:8080`

- open the /hello endpoint
- take a look at dev ui
