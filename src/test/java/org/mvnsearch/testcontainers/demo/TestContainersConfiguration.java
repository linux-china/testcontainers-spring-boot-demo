package org.mvnsearch.testcontainers.demo;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestContainersConfiguration {

    @Bean
    @ServiceConnection
    public RedisContainer redisContainer() {
        return new RedisContainer();
    }
}
