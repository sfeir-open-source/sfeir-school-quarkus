<!-- .slide: class="with-code" -->

# Build native

```
quarkus build --native
# or
./mvnw install -Dnative
```

Notes:

##==##

# Building native without GraalVM installed

```
quarkus build --native --no-tests -Dquarkus.native.container-build=true
# or
./mvnw install -Dnative -DskipTests -Dquarkus.native.container-build=true
```
