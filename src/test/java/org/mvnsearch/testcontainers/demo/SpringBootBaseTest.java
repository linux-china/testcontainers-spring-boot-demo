package org.mvnsearch.testcontainers.demo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * Spring Boot base test case
 *
 * @author linux_china
 */
@SpringBootTest
@Testcontainers
public abstract class SpringBootBaseTest {

    @Container
    public static RedisContainer redis = new RedisContainer();

    @DynamicPropertySource
    public static void redisProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.redis.host", redis::getContainerIpAddress);
        registry.add("spring.redis.port", () -> redis.getMappedPort(6379));
    }

}
