package org.mvnsearch.testcontainers.demo;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MySQLContainer;

@SuppressWarnings("resource")
@TestConfiguration(proxyBeanMethods = false)
public class TestContainersConfiguration {

    static GenericContainer<?> mailHog = new GenericContainer<>("mailhog/mailhog:latest")
            .withExposedPorts(1025, 8025);

    static {
        mailHog.start();
        System.setProperty("spring.mail.host", mailHog.getHost());
        System.setProperty("spring.mail.port", mailHog.getMappedPort(1025).toString());
    }

    @Bean
    public GenericContainer<?> mailHog() {
        return mailHog;
    }

    @Bean
    @ServiceConnection
    public RedisContainer redisContainer() {
        return new RedisContainer();
    }

    @Bean
    @ServiceConnection
    public MySQLContainer<?> mysqlContainer() {
        return new MySQLContainer<>("mysql:8.0.33");
    }
}
