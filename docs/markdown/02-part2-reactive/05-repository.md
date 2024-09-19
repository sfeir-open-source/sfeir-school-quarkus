<!-- .slide: class="with-code" -->

# Database - Repository

- In reactive, repository return Uni object (Mono in Spring)
  - asynchronous, non blocking
- You must subscribe on it
- repository object, implements **`PanacheRepository<YourObjectEntity>`**

##==##

<!-- .slide: class="with-code" -->

# Database - Repository - Annotate

- You can use standard annotation
  - ```java
    @ApplicationScopped
    @WithTransaction (Hibernate 6.2)
    ```

##==##

<!-- .slide: class="with-code" -->

# Database - Repository - Panache

- Panache is enable in reactive
  - lot of functions available
- ```java
  @ApplicationScoped
  @WithSession
  public class myRepository implements PanacheRepository<MyObject>{
        //some code
  }
  ```

##==##

<!-- .slide: class="exercice" -->

# Add the first repository

## Lab

**Goal** : Create your first Entity and Repository

[👉 Lab 02.02](https://github.com/sfeir-open-source/sfeir-school-quarkus/blob/main/steps/02.02-database-reactive/README.md)
