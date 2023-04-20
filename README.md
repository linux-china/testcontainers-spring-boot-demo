Testcontainers test
===================

### run in docker

```
 docker run -it --rm -v $PWD:$PWD -w $PWD -v /var/run/docker.sock:/var/run/docker.sock maven:3 mvn test
```

### References

* Testcontainers: https://www.testcontainers.org/
* Playtika testcontainers-spring-boot: Container auto-configurations for spring-boot based integration tests
* Spring Testing:  https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html
* Local development with Testcontainers: https://bsideup.github.io/posts/local_development_with_testcontainers/
* DB Integration Tests with Spring Boot and Testcontainers: https://www.baeldung.com/spring-boot-testcontainers-integration-test
* Guide to @DynamicPropertySource in Spring: https://www.baeldung.com/spring-dynamicpropertysource
* https://docs.spring.io/spring-framework/docs/5.2.5.RELEASE/spring-framework-reference/testing.html#testcontext-ctx-management-dynamic-property-sources
* Adding Integration Tests in Spring Boot with Testcontainers: https://bootify.io/docs/spring-boot-integration-tests-with-testcontainers.html
* testcontainers-auto-services-prototype: https://github.com/joshlong/testcontainers-auto-services-prototype
* The best way to use Testcontainers with Spring Boot: https://maciejwalkowiak.com/blog/testcontainers-spring-boot-setup/
* Spring Boot 3.1.0 support for Testcontainers Service Connections and Local Development: https://www.youtube.com/watch?v=UuLD9gZmiZU

