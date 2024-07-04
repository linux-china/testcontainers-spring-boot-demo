Spring Boot 3.2 with Testcontainers test
========================================

# Features

* Spring Boot Test
* Testcontainers integration
* Flyway integration
* Database rider integration
* GitHub Actions integration

# Reusable Containers

* Opt-in to Reusable Containers in `~/.testcontainers.properties`, by adding `testcontainers.reuse.enable=true`
* Add `.withReuse(true)` to the container configuration

```java

@TestConfiguration
static class ContainerConfiguration {

    @Bean
    @ServiceConnection
    RabbitMQContainer kafkaContainer() {
        return new RabbitMQContainer("rabbitmq:3.11-alpine")
                .withReuse(true);
    }
}
```

To stop and remove all containers started by Testcontainers:

```shell
$ docker ps --filter "label=org.testcontainers=true" -aq | xargs docker stop | xargs docker rm
```

# References

* Testcontainers: https://www.testcontainers.org/
* Mailpit - email testing for developers https://github.com/axllent/mailpit
* Spring Boot Testcontainers test: https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing.testcontainers
* Playtika testcontainers-spring-boot: Container auto-configurations for spring-boot based integration
  tests: https://github.com/PlaytikaOSS/testcontainers-spring-boot
* Spring Testing:  https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html
* Local development with Testcontainers: https://bsideup.github.io/posts/local_development_with_testcontainers/
* DB Integration Tests with Spring Boot and
  Testcontainers: https://www.baeldung.com/spring-boot-testcontainers-integration-test
* Guide to @DynamicPropertySource in Spring: https://www.baeldung.com/spring-dynamicpropertysource
* https://docs.spring.io/spring-framework/docs/5.2.5.RELEASE/spring-framework-reference/testing.html#testcontext-ctx-management-dynamic-property-sources
* Adding Integration Tests in Spring Boot with
  Testcontainers: https://bootify.io/docs/spring-boot-integration-tests-with-testcontainers.html
* testcontainers-auto-services-prototype: https://github.com/joshlong/testcontainers-auto-services-prototype
* The best way to use Testcontainers with Spring
  Boot: https://maciejwalkowiak.com/blog/testcontainers-spring-boot-setup/
* Spring Boot 3.1.0 support for Testcontainers Service Connections and Local
  Development: https://www.youtube.com/watch?v=UuLD9gZmiZU
* spring-boot-rabbitmq-testcontainers-reusable-mode: https://github.com/eddumelendez/spring-boot-rabbitmq-testcontainers-reusable-mode/tree/main
* Reusable Containers (Experimental): https://www.testcontainers.org/features/reuse/
* testcontainers-samples: https://github.com/eddumelendez/testcontainers-samples
* Spring Boot 3.1's ConnectionDetails abstraction: https://spring.io/blog/2023/06/19/spring-boot-31-connectiondetails-abstraction
* Stateful Testcontainers for Spring Boot 3.1 Dev Mode: https://learnings.aleixmorgadas.dev/p/stateful-testcontainers-for-spring
* Spring Tips: Testcontainers, Docker Compose, and Service Connections https://www.youtube.com/watch?v=msb2b3BeeQo

