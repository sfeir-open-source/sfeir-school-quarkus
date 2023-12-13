# Lab-00 Check prerequisites

**Goal** Check you setup

**Time** 5~20 minutes

# Tips

Launch following commands to check if everything needed is installed on your machine

- JDK 17+

```shell
java -version
echo $JAVA_HOME
```

- Maven 3.8.x

```shell
mvn -version
```

- Quarkus CLI

```shell
quarkus --version
```

- Docker and docker compose

```shell
docker version
docker compose version
```

Optional :

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

## If something is missing :

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
  https://www.oracle.com/java/technologies/downloads/#java17
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

- Quarkus CLI

  - MacOs

  ```shell
  brew install quarkusio/tap/quarkus
  ```

  - Linux Debian / Windows

  ```shell
  https://quarkus.io/guides/cli-tooling
  ```

- Docker

  https://docs.docker.com/engine/install/
