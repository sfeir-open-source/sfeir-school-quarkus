# Tâches à réaliser 

- Clone the Git repository or init a local maven project 
- Initialize the Quarkus project

# Tips

- #TODO Lien vers le repo Git

# TP


Go to the super-app directory
```shell
cd super-app
```

Use maven to create the Quarkus project
```shell
mvn io.quarkus:quarkus-maven-plugin:2.16.5.Final:create \
     -DprojectGroupId=com.sfeir.quarkus100 \
     -DprojectArtifactId=characters-micro-service \
     -DclassName="com.sfeir.quarkus100.CharactersResource" \
     -Dpath="api/characters" \
     -Dextensions="resteasy-reactive-jackson"
```

Add the new module in the parent pom.xml

```shell
<modules>
  <module>super-app/characters-micro-service</module>
</modules>
```

Launch the app from `characters-micro-service` directory

```shell
cd characters-micro-service
./mvnw quarkus:dev
```

Call url `http://localhost:8080/api/characters`

```shell
curl http://localhost:8080/api/characters
```



