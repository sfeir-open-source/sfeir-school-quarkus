# Lab - 03

**Goal** : Complete ```Character Service``` then expose a CRUD with ```CharacterResource```

## Steps

- Create a ```CharacterService```
- Implement following methods : 
  - ```random()```
  - ```persist(Character character)```
  - Bonus :
    - ```update(Character character)```
    - ```delete(Character character)```

- Use ```@Valid``` annotation where needed to validate ```Character```
- Use ```@Transactional``` where it fits
  - ```persist``` and ```delete``` should be REQUIRED
  - ```random``` should be SUPPORT
- Expose those newly implemented ```CharacterService``` methods through ```CharacterResource```

## Tips

For ```CharacterResource``` : 
- Use ```/random``` path
- Inject ```@Context UriInfo``` for the POST to create the content of the response

## Test your API

- Use the given Postman Collection in solution
- Or the following curl requests :

```shell
curl --location 'http://localhost:8080/api/characters' \
--header 'Content-Type: application/json' \
--data '{
    "name": "mario",
    "type": "MEDIUM",
    "speed": 7,
    "acceleration": 2.5
}'
```

```shell
curl --location 'http://localhost:8080/api/characters/1'
```

```shell
curl --location 'http://localhost:8080/api/characters/random'
```

```shell
curl --location --request PUT 'http://localhost:8080/api/characters' \
--header 'Content-Type: application/json' \
--data '{
    "id": 1,
    "name": "luigi",
    "type": "MEDIUM",
    "speed": 8,
    "acceleration": 2.5
}'
```

```shell
curl --location --request DELETE 'http://localhost:8080/api/characters/1' \
--header 'Content-Type: application/json' \
--data '{
    "id": 2,
    "name": "luigi",
    "type": "MEDIUM",
    "speed": 8,
    "acceleration": 2.5
}'
```
