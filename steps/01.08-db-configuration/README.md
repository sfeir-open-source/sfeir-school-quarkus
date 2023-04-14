# Lab - 04

**Goal** : Configure database

## Steps

- Go to the console and hit 'd' to open the dev console
- Go to Configuration > DevServices to find the db connection configuration
- Connect to the DB with your editor
- See that the ```type``` column is an integer -> we want to change that to have the full name
- In ```Character.java``` add the following annotation to the ```type``` field
```java
@Enumerated(EnumType.STRING)
```
- Copy / Paste the import.sql file in the resources directory
- If needed, add the following config to ```application.properties```
```text
quarkus.hibernate-orm.database.generation=drop-and-create
```
- Go back to your editor and see that the character table has been filled with import.sql content and the ```type``` column is now in clear text
