# Lab 01.05 - Play with database

**Goal** : Configure database

**Time** : 10~20 minutes

## Steps

- Go to Dev UI > Dev Services to find the db connection configuration
- Connect to the DB with your editor or a database client
- See that the `type` column is an integer -> we want to change that to have the name
- In `Character.java` add the following annotation to the `type` field

```java
@Enumerated(EnumType.STRING)
```

- Do another POST request to add a new character
- Go back to your editor and see that the `type` column is now in clear text
- If needed, add the following config to `application.properties`

```text
quarkus.hibernate-orm.database.generation=drop-and-create
```

- Copy / Paste the `import.sql` file in the resources directory
- Wait for the application reload or force it with a new request
- Go back to your editor and see that the character table has been filled with `import.sql` content
