<!-- .slide: class="with-code" -->
# Database - Entities

- JPA with Hibernate 
- Panache
  - Annotate class with **```@Entity```**
  - Extends **```PanacheEntity```** for active record pattern
  - Implements a **```PanacheRepository<Entity>```** for repository pattern
  - Annotate public fields with **```@Column```** to customize

- To add extensions 
```shell
./mvnw quarkus:add-extension -Dextensions="jdbc-postgresql,hibernate-orm-panache"
```

Notes:
Active record pattern or repository pattern
Encapsulation at runtime
Possible to write its own getter/setter

##==##
<!-- .slide: class="with-code" -->
# Database - Panache

- Automatically provide methods on entities
  - ```persist()```
  - ```listAll()```
  - ```findById()```
  - ```count()```
  - ...

<br>
<br>
<br>
Reference : <br> 
#TODO Finish to read reference

https://quarkus.io/guides/hibernate-orm-panache


##==##
<!-- .slide: class="with-code" -->
# Database - Validators

```shell
./mvnw quarkus:add-extension -Dextensions=hibernate-validator
```
#TODO standard Jakarta ? 
- Well known javax.validation.constraints
  - ```@NotNull```
  - ```@Size```
  - ```@Min``` ```@Max```
  - ```@NotBlank``` ```@NotEmpty```
  - ...

##==##
<!-- .slide: class="with-code" -->
# Database - Entity example

```java
@Entity
public class MyEntity extends PanacheEntity {

    @NotNull
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
