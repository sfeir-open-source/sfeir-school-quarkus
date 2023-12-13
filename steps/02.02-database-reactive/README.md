# Lab 02.02 - Create a first entity and repository

**Goal** Initialize the Quarkus project

**Time** 30~45 minutes

## Steps

- Go to the karts-microservice directory

```shell
cd karts-micro-service
```

- Add extensions

```shell
quarkus extension add reactive-pg-client hibernate-reactive-rest-data-panache
# or
./mvnw quarkus:add-extension -Dextensions="reactive-pg-client,hibernate-reactive-rest-data-panache"
```

- See that extensions have been added to the pom.xml file and that Quarkus is doing the hot reload

- Create an entity `Vehicle`
- With following fields
  - `id` (Long, auto-generated)
  - `name` (String, unique, not null, size 3-30)
  - `speed` (float, not null, 2 decimal)
  - `acceleration` (float, not null, 2 decimal)
- You can caught the import.sql in this folder to your resources folder

- Create an repository `VehicleRepository`
- With implements `PanacheRepository`

  - write method `findVehicleById` : return Vehicle by Id
  - write method `deleteVehicleById` : delete Vehicle by Id
  - write method `findAllVehicle()` : return all Vehicle
  - write method `createVehicle` : create Vehicule passed in parameter
  - write method `updateVehicle` : update Vehicle with Vehicle and id passed in parameter

- Call your `VehicleRepository` from `KartsResource` to return all vehicules on endpoint `/api/karts`
