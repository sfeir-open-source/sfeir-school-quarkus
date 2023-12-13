# Lab 02.03 - CRUD API

**Goal** : Complete `Kart Service` then expose a CRUD with `KartResource`

**Time** : 30~45 minutes

## Steps

- Create a `KartService`
- Implement following methods :

  - `random()`
  - `findAll()`
  - `findByName(String name)`
  - Bonus :
    - `update(Long id,Vehicle vehicle)`
    - `deleteByName(String name)`
    - `create(Vehicle vehicle)`

- Use `@Valid` annotation where needed to validate `Kart`
- Expose those newly implemented `KartService` methods through `KartResource`

## Test your API

- Use the following curl requests :

```shell
curl --location 'http://localhost:8084/api/karts' \
--header 'Content-Type: application/json' \
--data '{
        "name": "test",
        "speed": 0.0,
        "acceleration": 0.0
    }'
```

```shell
curl 'http://localhost:8084/api/kars/1'
```

```shell
curl --location 'http://localhost:8084/api/kars/random'
```

```shell
curl --location --request PUT 'http://localhost:8084/api/kars' \
--header 'Content-Type: application/json' \
--data '{
        "id":1,
        "name": "updatedKart",
        "speed": 0.0,
        "acceleration": 0.0
    }'
```

```shell
curl --location --request DELETE 'http://localhost:8084/api/kars/1' \
--header 'Content-Type: application/json' \
--data '{
        "id":1,
        "name": "updatedKart",
        "speed": 0.0,
        "acceleration": 0.0
    }'
```
