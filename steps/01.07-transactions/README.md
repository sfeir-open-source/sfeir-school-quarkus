# Tâches à réaliser 

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

