<!-- .slide: class="with-code" -->
# Database - Entities

- JPA with Hibernate 
- Panache
  - Extends ```PanacheEntity```
  - Annotate class with ```@Entity```
  - Annotate fields with ```@Column``` to customize

- To add extensions 
```shell
./mvnw quarkus:add-extension -Dextensions="jdbc-postgresql,hibernate-orm-panache,hibernate-validator"
```

Notes:

##==##

# Database - Panache

- Automatically provide methods on entities
  - ```persist()```
  - ```listAll()```
  - ```findById()```
  - ```count()```
  - ...

##==##

# Database - Entity example

```java
@Entity
public class MyEntity extends PanacheEntity {

    @Column(length = 30)
    public String name;
    public int speed;

    public static Character findByName(String name){
      return find("name", name).firstResult();
    }
    
}
```


##==##
<!-- .slide: class="exercice" -->
# Add the first entity

## Lab

**Goal** : Add needed extensions and create the Character Entity

[👉 Lab 2](https://github.com/sfeir-open-source/sfeir-school-quarkus/blob/speaker/steps/01.06-database/README.md)


