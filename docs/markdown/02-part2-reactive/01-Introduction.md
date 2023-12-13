<!-- .slide: class="transition bg-pink" -->

# Quarkus Reactive

##==##

<!-- .slide: class="with-code" -->

# What is it ?

- Reactive programming is a event programmation with hight performance
  - your request is never blocked
  - the user get the response so fast

![quarkus not reactive](./assets/images/quarkus_not_reactive.png)

![quarkus_reactive](./assets/images/quarkus_reactive.png)
##==##

<!-- .slide: class="with-code" -->

# Why do you use it ?

- Quarkus recommend to use it to manage handle asynchronous data streams and events

  - for example : a lot of requests in same time

- Asynchronous Component : all the operation are non-blocking (database driver too)

  - maximize processing capacity

- Quarkus Reactive is a extension => use it with other extension

- Vert.x optimize the I/O
  ##==##

<!-- .slide: class="with-code" -->

# CRUD API for Kart

- REST API, CRUD operations, reactive , reactive driver

- new dependencies

  - resteasy-reactive
  - resteasy-reactive-jackson

- Goal : Crud for kart

##==##

<!-- .slide: class="exercice" -->

# Init module

## Lab

**Goal** : Initialize the second micro-service

[👉 Lab 02.01](https://github.com/sfeir-open-source/sfeir-school-quarkus/blob/main/steps/02.01-init-kart-module/README.md)
