<!-- .slide: class="with-code" -->
# Service

##==##
<!-- .slide: class="with-code" -->
# Service

- **```@ApplicationScoped```** to declare a bean
- Dependency Injection
  - Standard : **CDI** with **ArC**
  - Build time oriented
    - ✅ Fail fast
    - ✅ Instant startup
    - ✅ Minimized runtime 
    - ✅ Optimized Code Paths and Metadata Structures

Reference : https://quarkus.io/blog/quarkus-dependency-injection and https://quarkus.io/guides/cdi-reference
<!-- .element: class="credits" -->


Notes:
- CDI : Context and Dependency Injection
- Fail fast : validated at build time -> no error in production
- Minimize runtime : 7% of the Weld 3.1.1 CDI implementation reference, 72 classes
- Optimized Code Paths and Metadata Structures : aim to develop those optimizations
- Arc is not a full CDI implementation

##==##
<!-- .slide: class="with-code" -->
# CDI - Dependency injection

Via **```@Inject```** on a field
```java
@Inject
Logger logger;
```
Or directly via the **constructor**
```java
public CharacterResource(Logger logger){
    this.logger = logger;
};
```

##==##
<!-- .slide: class="with-code" -->
# Transactions

##==##
<!-- .slide: class="with-code" -->
# Transactions

Standard : JTA

- **@Transactional**
  - Class level
  - Method level
  - On any bean
- Types :
  - REQUIRED
  - REQUIRE_NEW
  - MANDATORY
  - SUPPORTS
  - NOT_SUPPORTED
  - NEVER

Reference : https://www.oracle.com/java/technologies/jta.html
<!-- .element: class="credits" -->


Notes:
- JTA : Java Transaction API
- REQUIRED : starts new if none
- REQUIRE_NEW : suspend current and start new
- MANDATORY : fail if none
- SUPPORTS : join existing or continue if none
- NOT_SUPPORTED : suspend existing and continue
- NEVER : fail if existing

##==##
<!-- .slide: class="with-code" -->
# Example
```java
@ApplicationScoped
@Transactional(Transactional.TxType.SUPPORTS)
public class EntityService {
    private final Logger logger;
    
    public EntityService(Logger logger){this.logger = logger;}

    public List<Character> findEntityById(Long id){
        return Entity.findById(id);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public Entity persist(@Valid Entity entity) {
        entity.persist();
        return entity;
    }
}
```

##==##
<!-- .slide: class="with-code" -->
# Resource - Rappel
```java [2,5-6]

@Path("/api/characters")
public class CharactersResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }
}
```


##==##
<!-- .slide: class="with-code" -->
# Resource - Annotations

Standard : JAX-RS

- ```@Path(/api/domain/{variableName})```
- ```@RestPath Object variableName```
- ```@GET```
- ```@POST```
- ```@PUT```
- ```@DELETE```

Reference: https://www.oracle.com/technical-resources/articles/java/jax-rs.html
<!-- .element: class="credits" -->

Notes:
JAX-RS : Java API for RESTful Webservices

##==##
<!-- .slide: class="with-code" -->
# Resource - Response

- **```RestResponse<?>```**

With static methods :
  - **```.ok(T entity)```**
  - **```.created(URI location)```**
  - **```.noContent()```**
  - and more

##==##
<!-- .slide: class="exercice" -->
# Create a CRUD API
## Lab

[👉 Lab 3](https://github.com/sfeir-open-source/sfeir-school-quarkus/blob/speaker/steps/01.07-crud-api/README.md)

