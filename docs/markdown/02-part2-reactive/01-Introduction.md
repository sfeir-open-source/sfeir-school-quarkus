<!-- .slide: class="transition bg-pink" -->

# Quarkus Reactive

##==##
<!-- .slide: class="with-code" -->
# Why do you use it ?

* Quarkus recommend to use it to manage handle asynchronous data streams and events
  * for example : a lot of requests in same time

* Asynchronous Component : all the operation are non-blocking (database driver too)
  * maximize processing capacity

* Quarkus Reactive is a extension => use it with other extension

* Reactives Streams : an asynchronous stream processing API. 
  * This API allows efficient management of asynchronous data streams and events.

* Vert.x optimize the I/O
##==##

<!-- .slide: class="with-code" -->
# CRUD API for Kart 

* REST API, CRUD operations, reactive , reactive driver

* new dependency
  * resteasy-reactive

##==##
<!-- .slide: class="exercice" -->

# Init module
## Lab

**Goal** : Initialize the second micro-service

[👉 Lab 6](https://github.com/sfeir-open-source/sfeir-school-quarkus/blob/speaker/steps/02.01-init-kart-module/README.md)

