<!-- .slide: class="with-code" -->
# Crud Api Reactive

* Quarkus API REST Architecture likely similar to Spring
  * Resource (Ws)
  * Service
  * Repository
  * Models

* business logic are in service.
* Transaction
  * **```@WithTransaction```** (in quarkus 3)
  * **```@ReactiveTransaction```** (in quarkus 2)

##==##
<!-- .slide: class="with-code" -->
# Service

* Service link Resources with Repository
  * it's a bean

```java
   @ApplicationScoped
   public class MyService{
      //some code
   }
```

* some code contains all business logic
  
##==##
<!-- .slide: class="with-code" -->
# Dependency Injection

- **```@ApplicationScoped```** to declare a bean
- Dependency Injection
  - Standard : **CDI** with **ArC**
  - Via **```@Inject```** on a field

```java
@Path('api/test')
@ApplicationScoped
public class MyWebService{

@Inject
MyService myservice

}
```
##==##
<!-- .slide: class="with-code" -->
# Transaction

* Your API must 
  * Use Transaction in Resource
  * Use Session in Repository

```java
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @WithTransaction
    public Uni<Response> update(@PathParam("id") Long id, MyObj myObj) {
        myObjService.update(id, myObj);
        return Uni.createFrom().item(Response.ok().build());
    }
```
##==##
<!-- .slide: class="exercice" -->
# Create your subatomic API !
## Lab

**Goal** : Create your first Repository

[👉 Lab 9](https://github.com/sfeir-open-source/sfeir-school-quarkus/tree/main/steps/02.04-crud-api-reactive/README.md)



