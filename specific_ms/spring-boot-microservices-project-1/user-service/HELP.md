# Read Me First
The following was discovered as part of building this project:

* The original package name 'org.fve.microservices.user-service' is invalid and this project uses 'org.fve.microservices.userservice' instead.

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
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#web)
* [Validation](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#io.validation)
* [OpenFeign](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#messaging.kafka)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#web.security)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Service Registration and Discovery with Eureka and Spring Cloud](https://spring.io/guides/gs/service-registration-and-discovery/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)

### Additional Links
These additional references should also help you:

* [Declarative REST calls with Spring Cloud OpenFeign sample](https://github.com/spring-cloud-samples/feign-eureka)

### Docker Compose support
This project contains a Docker Compose file named `compose.yaml`.
In this file, the following services have been defined:

* mysql: [`mysql:latest`](https://hub.docker.com/_/mysql)
* zipkin: [`openzipkin/zipkin:latest`](https://hub.docker.com/r/openzipkin/zipkin/)

Please review the tags of the used images and set them to the same as you're running in production.

