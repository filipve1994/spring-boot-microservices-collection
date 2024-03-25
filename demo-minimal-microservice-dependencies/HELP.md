# Read Me First
The following was discovered as part of building this project:

* The original package name 'org.fve.microservices.demo-minimal-microservice-dependencies' is invalid and this project uses 'org.fve.microservices.demominimalmicroservicedependencies' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.4/maven-plugin/reference/html/#build-image)
* [Distributed Tracing Reference Guide](https://micrometer.io/docs/tracing)
* [Getting Started with Distributed Tracing](https://docs.spring.io/spring-boot/docs/3.2.4/reference/html/actuator.html#actuator.micrometer-tracing.getting-started)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#actuator)
* [Docker Compose Support](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#features.docker-compose)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#appendix.configuration-metadata.annotation-processor)
* [codecentric's Spring Boot Admin (Client)](https://codecentric.github.io/spring-boot-admin/current/#getting-started)
* [Eureka Discovery Client](https://docs.spring.io/spring-cloud-netflix/docs/current/reference/html/#service-discovery-eureka-clients)
* [Config Client Quick Start](https://docs.spring.io/spring-cloud-config/docs/current/reference/html/#_client_side_usage)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Service Registration and Discovery with Eureka and Spring Cloud](https://spring.io/guides/gs/service-registration-and-discovery/)

### Docker Compose support
This project contains a Docker Compose file named `compose.yaml`.
In this file, the following services have been defined:

* zipkin: [`openzipkin/zipkin:latest`](https://hub.docker.com/r/openzipkin/zipkin/)

Please review the tags of the used images and set them to the same as you're running in production.

