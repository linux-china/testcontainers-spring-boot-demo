Testcontainers test
===================


### run in docker
```
 docker run -it --rm -v $PWD:$PWD -w $PWD -v /var/run/docker.sock:/var/run/docker.sock maven:3 mvn test
```

### References

* Testcontainers: https://www.testcontainers.org/
* Local development with Testcontainers: https://bsideup.github.io/posts/local_development_with_testcontainers/
* https://docs.spring.io/spring-framework/docs/5.2.5.RELEASE/spring-framework-reference/testing.html#testcontext-ctx-management-dynamic-property-sources
* Adding Integration Tests in Spring Boot with Testcontainers: https://bootify.io/docs/spring-boot-integration-tests-with-testcontainers.html

