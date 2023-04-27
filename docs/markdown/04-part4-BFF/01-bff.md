<!-- .slide: class="transition bg-pink" -->
# Racer microservice - Back For Front


##==##
<!-- .slide: class="with-code" -->
# Http Communication

##==##
<!-- .slide: class="with-code" -->
# Http Communication

- Standard : MicroProfile RestClient
- Annotate an interface with `@RegisterRestClient`
- Use JAX-RS annotations to declare end points : `@Path`, `@Get`...
- Inject dependency with `@RestClient`

Reference : https://github.com/eclipse/microprofile-rest-client
<!-- .element: class="credits" -->


##==##
<!-- .slide: class="with-code" -->
# Scopes 

Define the scope on the interface with annotations 

- @Dependent (default)
- @Singleton
- @ApplicationScoped
- @RequestScoped

Or in application.properties<br>
```text
com.sfeir.quarkus100.racer.client.MyWebClient/mp-rest/scope=javax.inject.Singleton
```

Notes:<br>

##==##
<!-- .slide: class="with-code" -->
# Example

```java
@Path("/api/resources")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
@Singleton
public interface MyWebClient {

    @GET
    MyResource get();
}
```
```java [4-5]
@ApplicationScoped
public class MyService {

    @RestClient
    MyWebClient webClient;

    [...]
}
```
Notes:<br>

##==##
<!-- .slide: class="with-code" -->
# How to Mock ? 

##==##
<!-- .slide: class="with-code" -->
# How to Mock ? 

With an alternative bean

##==##
<!-- .slide: class="with-code" -->
# How to Mock ?

With an alternative bean

Use annotations on the alternative bean

- @Alternative
- @Priority(1)
<br>
or 
- @Mock stereotype 

Notes:<br>
@Mock stereotype contains @Alternative, @Priority(1), @Dependent


##==##
<!-- .slide: class="with-code" -->
# How to Mock ?

With an alternative bean

Use annotations on the alternative bean

- @Alternative
- @Priority(1)
<br>
or 
- @Mock stereotype 

Create the alternative bean in the same package in **test sources**

```java [1-3]
@Mock
@RestClient
public class MyWebClientMock implements MyWebClient {
    
    @Override
    public MyResource get() {
        [...]
    }
}
```

##==##
<!-- .slide: class="with-code" -->
# Fault Tolerance & Timeout

##==##
<!-- .slide: class="with-code" -->
# Fault Tolerance & Timeout

```shell
./mvnw quarkus:add-extension -Dextensions="smallrye-fault-tolerance"
```

```java [1]
@Fallback(fallbackMethod = "myFallbackMethod")
MyResource getResource(){
    [...]
  }
```

```java [3]
@Path("/resource")
@GET
@Timeout(500)
public Response getMyResource() {
    [...]
}
```

Notes:<br>

##==##
<!-- .slide: class="with-code" -->
# Retry & CircuitBreaker

```java [10|11-14]
@ApplicationScoped
public class MyResourceClient {

    private final MyResourceAPI resourceAPI;

    public MyResourceClient(@RestClient MyResourceAPI resourceAPI) {
        this.resourceAPI = resourceAPI;
    }

    @Retry(maxRetries = 3, delay = 200)
    @CircuitBreaker(requestVolumeThreshold = 4,
            failureRatio = 0.5,
            delay = 2,
            delayUnit = ChronoUnit.SECONDS)
    public MyResource getResource() {
        return resourceAPI.get();
    }
}
```

Notes:<br>
Circuit Breaker will suspend the call to the method if error conditions are met.<br>
After delay it will make another call, if the call fails it suspends again.

##==##
<!-- .slide: class="exercice" -->
# Create the Back For Front microservice
## Lab

[👉 Lab 11](https://github.com/sfeir-open-source/sfeir-school-quarkus/blob/main/steps/04.01/README.md)




