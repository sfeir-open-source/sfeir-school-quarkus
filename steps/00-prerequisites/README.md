# Tâches à réaliser 

- Vérifier l'installation des pré-requis

# Tips

Lancer les commandes suivantes pour vérifier que tout le nécessaire est installé

- JDK 17+
```shell
java -version
echo $JAVA_HOME
```

- Maven 3.8.x
```shell
mvn -version
```

- Docker et docker compose
```shell
docker version
docker compose version
```

Optionel :

- GraalVM
```shell
$GRAALVM_HOME/bin/native-image --version
```

- cURL:
```shell
curl --version
```

- Kubernetes
```shell
kubectl version 
```

# TP

Si il manque des choses : 
- JDK 17 
  - MacOS
  ```shell
  brew install java17
  ```
  - Linux Debian
  ```shell
  apt-get install openjdk-17-jd
  ```
  - Windows
  ```shell
  #TODO mettre du java 17
  https://docs.oracle.com/en/java/javase/11/install/installation-jdk-microsoft-windows-platforms.html#GUID-DAF345BA-B3E7-4CF2-B87A-B6662D691840
  ```

- Maven
  - MacOS
  ```shell
  brew install maven
  ```
  - Linux Debian / Windows
  ```shell
  https://maven.apache.org/install.html
  ```
