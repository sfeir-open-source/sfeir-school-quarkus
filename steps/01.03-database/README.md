# Lab 01.03 - Create a first entity

**Goal** Discover the Panache way of accessing data

**Time** 15~20 minutes

## Steps

- Add extensions for jdbc with postgresql, hibernate validation and panache

```shell
quarkus extension add jdbc-postgresql hibernate-orm-panache hibernate-validator
# or
./mvnw quarkus:add-extension -Dextensions="jdbc-postgresql,hibernate-orm-panache,hibernate-validator"
```

- See that extensions have been added to the pom.xml file and that Quarkus is doing the hot reload
- Create the enum `CharacterType`

```java
public enum CharacterType {
    FEATHERWEIGHT,
    LIGHT,
    MEDIUM,
    CRUISER,
    HEAVY
}
```

- Create an entity `Character`
- With following fields
  - `name` (String, unique, not null, size 3-30)
  - `speed` (int, not null)
  - `acceleration` (float, not null, 2 decimal)
  - `type` (CharacterType, not null)
- Implement a method `findByName` with `find`
- Implement a method `findByType` with `find`
- Implement a method `random` that returns a random `Character`
