<!-- .slide: class="with-code" -->

# Database - Entities

- Standard : JPA with Hibernate
- Panache
  - Annotate class with **`@Entity`**
  - Extends **`PanacheEntity`** for active record pattern
  - Implements a **`PanacheRepository<Entity>`** for repository pattern
  - Annotate public fields with **`@Column`** to customize

Extensions :

- jdbc-postgresql
- hibernate-orm-panache

```shell
quarkus extension add jdbc-postgresql hibernate-orm-panache
# or
./mvnw quarkus:add-extension -Dextensions="jdbc-postgresql,hibernate-orm-panache"
```

Notes:
JPA : Java Persistence API
Active record pattern or repository pattern
Encapsulation at runtime
Possible to write its own getter/setter

##==##

<!-- .slide: class="with-code" -->

# Database - Panache

- Automatically provide methods on entities

```Java
var character = new CharacterEntity(1L, "Luigi");
character.persist();

var allCharacters = Character.listAll();
var charactersCount = Character.count();
var luigi = Character.findById(1L);
```

Reference : https://quarkus.io/guides/hibernate-orm-panache

<!-- .element: class="credits" -->

##==##

<!-- .slide: class="with-code" -->

# Database - Validators

- Standard : Jakarta Bean Validation
- Well known javax.validation.constraints
  - `@NotNull`
  - `@Size`
  - `@Min` `@Max`
  - `@NotBlank` `@NotEmpty`
  - and more

Extension : hibernate-validator

```shell
quarkus extension add hibernate-validator
# or
./mvnw quarkus:add-extension -Dextensions=hibernate-validator
```

Reference : https://beanvalidation.org/

<!-- .element: class="credits" -->

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

[👉 Lab 01.03](https://github.com/sfeir-open-source/sfeir-school-quarkus/blob/main/steps/01.03-database/README.md)
