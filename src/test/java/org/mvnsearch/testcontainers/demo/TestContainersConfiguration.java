package org.mvnsearch.testcontainers.demo;

import org.mvnsearch.testcontainers.demo.redis.RedisContainer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MySQLContainer;

@SuppressWarnings("resource")
@TestConfiguration(proxyBeanMethods = false)
public class TestContainersConfiguration {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Bean()
    public GenericContainer<?> mailpit(DynamicPropertyRegistry properties) {
        GenericContainer<?> mailpit = new GenericContainer<>("axllent/mailpit:v1.19").withExposedPorts(1025, 8025);
        properties.add("spring.mail.host", mailpit::getHost);
        properties.add("spring.mail.port", () -> mailpit.getMappedPort(1025).toString());
        return mailpit;
    }

    @Bean
    @ServiceConnection("redis")
    public RedisContainer redisContainer() {
        return new RedisContainer();
    }

    @Bean
    @ServiceConnection
    public MySQLContainer<?> mysqlContainer() {
        return new MySQLContainer<>("mysql:8.0.33").withReuse(true);
    }
}
