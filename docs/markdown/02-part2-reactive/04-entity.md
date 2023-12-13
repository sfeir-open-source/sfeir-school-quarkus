<!-- .slide: class="with-code" -->

# Database - Entities

- Standard : JPA with Hibernate
- Annotate class with **`@Entity`**
- Annotate public fields with **`@Column`** to customize

Extensions :

- hibernate-reactive-rest-data-panache
- reactive-pg-client

```shell
quarkus extension add hibernate-reactive-rest-data-panache reactive-pg-client
# or
./mvnw quarkus:add-extension -Dextensions="hibernate-reactive-rest-data-panache,reactive-pg-client"
```

##==##

<!-- .slide: class="with-code" -->

# Entity - tips

- Quarkus add private encapsulation automatically.
- You can put all the element public
  - when compile, quarkus put getter / setter and change to private encapsulation

<!-- .element: class="credits" -->

##==##

<!-- .slide: class="with-code" -->

# Database - Validators

- Standard : Jakarta Bean Validation
- but is not javax !
- Well known jakarta.validation.constraints
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
public class MyEntity {

    @NotNull
    @Column(length = 30)
    public String name;
    public int speed;
}
```

- in reactive with repository pattern, is the repository who talk with database
