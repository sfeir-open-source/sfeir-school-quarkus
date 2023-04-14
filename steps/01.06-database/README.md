# Tâches à réaliser 

- Add extensions
- Create an enum ```CharacterType```
- Create an entity ```Character```
- Add following fields 
  - ```name``` (String, unique, not null, size 3-30)
  - ```speed``` (int, not null)
  - ```acceleration``` (float, not null, 2 decimal)
  - ```type``` (CharacterType, not null)
- Implement a method ```findByName``` with ```find```
- Implement a method ```findByType``` with ```find```
- Implement a method ```random``` that returns a random ```Character```


# Tips

- The enum Character type should look like this : 
```java
public enum CharacterType {
    FEATHERWEIGHT,
    LIGHT,
    MEDIUM,
    CRUISER, 
    HEAVY
}
```

# TP

Go to the  characters-microservice directory
```shell
cd super-app/characters-microservice
```

Use maven to add extensions
```shell
./mvnw quarkus:add-extension -Dextensions="jdbc-postgresql,hibernate-orm-panache,hibernate-validator"
```

See that extensions have been added to the pom.xml file and that Quarkus is doing the hot reload.


