# Tâches à réaliser 

- Cloner le repo Git
- Initialiser le projet Quarkus

# Tips

- Lien vers le repo Git

# TP


Placer vous dans le repo super-app
```shell
cd super-app
```

Utiliser maven pour créer le projet Quarkus
```shell
mvn io.quarkus:quarkus-maven-plugin:2.16.5.Final:create \
     -DprojectGroupId=com.sfeir.quarkus100 \
     -DprojectArtifactId=characters-micro-service \
     -DclassName="com.sfeir.quarkus100.CharactersResource" \
     -Dpath="api/characters" \
     -Dextensions="resteasy-reactive-jackson"
```

Ajouter le nouveau module dans le pom parent pour qu'il soit pris en compte par l'IDE

```shell
<modules>
  <module>super-app/characters-micro-service</module>
</modules>
```

Lancer l'application depuis le répertoire `characters-micro-service`

```shell
cd characters-micro-service
./mvnw quarkus:dev
```

Appeler l'url `http://localhost:8080/api/characters`

```shell
curl http://localhost:8080/api/characters
```



