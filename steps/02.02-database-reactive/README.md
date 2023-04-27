# Lab-07 Create a first entity

**Goal** Initialize the Quarkus project

**Time** 15~20 minutes

## Steps

- Go to the  karts-microservice directory
```shell
cd karts-micro-service
```
- Add extensions

```shell
./mvnw quarkus:add-extension -Dextensions="reactive-pg-client,hibernate-reactive-rest-data-panache"
```

- See that extensions have been added to the pom.xml file and that Quarkus is doing the hot reload
 

- Create an entity ```Vehicle```
- With following fields
  - ```id``` (Long, auto-generated)
  - ```name``` (String, unique, not null, size 3-30)
  - ```speed``` (float, not null, 2 decimal)
  - ```acceleration``` (float, not null, 2 decimal)
- You can caught the import.sql in this folder to your resources folder

