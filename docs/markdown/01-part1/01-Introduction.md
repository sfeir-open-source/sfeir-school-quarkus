<!-- .slide: class="transition bg-pink" -->
# Pre-requisites

##==##
<!-- .slide: class="exercice" -->
# Check your setup

## Lab
**Goal** : Verify pre-requisites

[👉 Lab 0](https://github.com/sfeir-open-source/sfeir-school-quarkus/blob/speaker/steps/00-prerequisites/README.md)

Notes:
tanguy

##==##
<!-- .slide: class="transition bg-pink" -->

# Quarkus


##==##
<!-- .slide: class="with-code" -->
# Why Quarkus ? 

- Java 25+ years
- Applications no longer runs on big machines
- Density is the new optimization
- **Goal** : Make Java the leading platform for cloud applications
<!-- .element: class="list-fragment" -->

Notes:<br>
tanguy
Java ecosystem need to be modernized to fit the new way of deploying applications

##==##
<!-- .slide: class="with-code" -->
# Quarkus Features

- Container First
- Unifies imperative and reactive
- Community and standards
- Kubernetes native
- Developer Joy
<!-- .element: class="list-fragment" -->

Reference: https://quarkus.io/
<!-- .element: class="credits" -->

Notes:
tanguy
Tailored for GraalVM and HotSpot
Unifies imperative and reactive : both in the same application

##==##
<!-- .slide: class="with-code" -->
# Quarkus Features
## Container First

- Optimized for low memory usage
- Fast startup times
  - Build Time processing
  - Reduction in Reflection Usage
  - GraalVM Native images support
  - Native image preboot
<!-- .element: class="list-fragment" -->

Reference: https://quarkus.io/container-first/
<!-- .element: class="credits" -->

Notes:<br>
nathan
Do at build-time what is usually done at runtime
Avoid reflection and dynamic proxies
ArC determines the injection graph at build time
Native image preboot : the native executable has already run most of the startup code, 
the result is serialized into the executable

##==##
<!-- .slide: class="with-code" -->
# Quarkus Features
## Imperative and reactive

- Http Service
- gRPC
- GraphQL
- Event-driven with Reactive Messaging
- Functions as a Service with Funqy
<!-- .element: class="list-fragment" -->


References :
https://quarkus.io/continuum/ and 
https://quarkus.io/guides/quarkus-reactive-architecture
<!-- .element: class="credits" -->


Notes:<br>
tanguy
Client / server is not the only model anymore : 
HTTP microservices, reactive applications, event-driven architectures, serverless

##==##
<!-- .slide: class="with-code" -->
# Quarkus Features
## Community and standards

OpenSource<br>
<br>
Built on top of proven standards

- CDI for dependency injection
- JAX-RS annotations for REST endpoints
- JPA for persistent entities
- JTA for transactions boundaries
- Eclipse MicroProfile to configure and monitor
- and much more<br>
<!-- .element: class="list-fragment" -->


Reference: https://quarkus.io/standards/
<!-- .element: class="credits" -->

Notes:<br>
nathan
Quarkus is not just a consumer it also aims to improve and contribute to existing technologies

##==##
<!-- .slide: class="with-code" -->
# Quarkus Features
## Kube-Native

- Single step deployment with Kubernetes extensions
- Extensions to deploy serverless microservices
- OpenTracing to debug distributed microservices
- Health and Metrics : SmallRyeHealth and Micrometer
- Extension to use Kube ConfigMap and Secrets as configuration source
- Remote Development
<!-- .element: class="list-fragment" -->

Reference : https://quarkus.io/kubernetes-native/
<!-- .element: class="credits" -->

Notes:<br>
tanguy
Extensions for Kubernetes that simplifies the deployment<br>
Remote dev to live code, all changes made locally will be visible in the cluster environment

##==##
<!-- .slide: class="with-code" -->
# Quarkus Features
## Developer Joy

- Live Coding
- Unified Config 
- Opinionated
- Dev UI
- Dev Services
- Continuous Testing
- Command Line Interface
<!-- .element: class="list-fragment" -->

Reference : https://quarkus.io/developer-joy/
<!-- .element: class="credits" -->

Notes:<br>
tanguy
A single config file<br>
DevServices automatic provisioning 

##==##
<!-- .slide: class="transition bg-pink" -->

# First micro-service

##==##
<!-- .slide: class="with-code" -->
# Content for this first micro-service
#TODO présentation du premier micro-service 

-> REST API, CRUD operations, imperative 

Comment créer une application Quarkus

Notes:<br>
tanguy

##==##
<!-- .slide: class="exercice" -->
# Init module
## Lab

**Goal** : Initialize the first micro-service

[👉 Lab 1](https://github.com/sfeir-open-source/sfeir-school-quarkus/blob/speaker/steps/01.01-init-character-module/README.md)

