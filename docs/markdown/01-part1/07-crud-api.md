<!-- .slide: class="with-code" -->
# Database - Transactions

- @Transactional
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


Notes:
- REQUIRED : starts new if none
- REQUIRE_NEW : suspend current and start new
- MANDATORY : fail if none
- SUPPORTS : join existing or continue if none
- NOT_SUPPORTED : suspend existing and continue
- NEVER : fail if existing

##==##
<!-- .slide: class="with-code" -->
# Service

- **```@ApplicationScoped```** to declare a bean
- Dependy Injection with **ArC** : build time oriented
  - ✅ Fail fast
  - ✅ Instant startup
  - ✅ Minimized runtime 
  - ✅ Optimized Code Paths and Metadata Structures

<br>
<br>
<br>
Reference :

https://quarkus.io/blog/quarkus-dependency-injection
<br>
https://quarkus.io/guides/cdi-reference

Notes:
- Fail fast : validated at build time -> no error in production
- Minimize runtime : 7% of the Weld 3.1.1 CDI implementation reference, 72 classes
- Optimized Code Paths and Metadata Structures : aim to develop those optimizations
- Extensions Point ? limit 
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
```java

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

- ```@Path(/api/domain/{variableName})```
- ```@RestPath Object variableName```
- ```@GET```
- ```@POST```
- ```@PUT```
- ```@DELETE```


##==##
<!-- .slide: class="with-code" -->
# Resource - Response

- **```RestResponse<?>```**

With static methods :
  - **```.ok(T entity)```**
  - **```.created(URI location)```**
  - **```.noContent()```**
  - ...

To build the **```location```**
- Inject **```UriInfo```** with **```@Context```** annotation
- Then use **```.getAbsolutePathBuilder()```**

##==##
<!-- .slide: class="exercice" -->
# Create a CRUD API

[👉 Lab 3](https://github.com/sfeir-open-source/sfeir-school-quarkus/blob/speaker/steps/01.07-transactions/README.md)

