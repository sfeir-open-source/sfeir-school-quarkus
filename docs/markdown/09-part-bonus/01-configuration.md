<!-- .slide: class="with-code" -->

# Configuration

```properties
quarkus.http.port=8088
quarkus.rest-client.character-api.url=http://localhost:8080
```

Notes:

##==##

<!-- .slide: class="with-code" -->

# Configuration

```properties
quarkus.http.port=8080
%dev.quarkus.http.port=8088
%test.quarkus.http.port=9000
quarkus.rest-client.character-api.url=http://localhost:8080
%prod.quarkus.rest-client.character-api.url=https://character-api.example.com
```

Notes:

##==##

<!-- .slide: class="with-code" -->

# Configuration

```properties
quarkus.http.port=8080
%dev.quarkus.http.port=8088
%test.quarkus.http.port=9000
```

```
# .env
QUARKUS_HTTP_PORT=9090
_DEV_QUARKUS_HTTP_PORT=9091
```

Notes:

##==##

<!-- .slide: class="with-code" -->

# Configuration

```properties
remote.host=quarkus.io
application.host=${HOST:${remote.host}}

foo.id=${quarkus.uuid}

my.secret=${aes-gcm-nopadding::DJNrZ6LfpupFv6QbXyXhvzD8eVDnDa_kTliQBpuzTobDZxlg}
# the encryption key required to decode the secret. It can be set in any source.
smallrye.config.secret-handler.aes-gcm-nopadding.encryption-key=somearbitrarycrazystringthatdoesnotmatter
```

Notes:

##==##

# Custom Configuration

```Java
@ConfigProperty(name = "greeting.message")
String message;

@ConfigProperty(name = "greeting.suffix", defaultValue="!")
String suffix;

@ConfigProperty(name = "greeting.name")
Optional<String> name;
```
