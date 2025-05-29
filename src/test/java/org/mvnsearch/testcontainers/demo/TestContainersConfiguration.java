package org.mvnsearch.testcontainers.demo;

import org.mvnsearch.testcontainers.demo.redis.RedisContainer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistrar;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

@SuppressWarnings("resource")
@TestConfiguration(proxyBeanMethods = false)
public class TestContainersConfiguration {

    @Container
    static GenericContainer<?> mailpit = new GenericContainer<>("axllent/mailpit:v1.25.1").withExposedPorts(1025, 8025);
    @Container
    static GenericContainer<?> natsServer = new GenericContainer<>("nats:2.11.4-alpine3.21").withExposedPorts(4222);

    @Bean
    public DynamicPropertyRegistrar dynamicPropertyRegistrar() {
        return registry -> {
            registry.add("spring.mail.host", mailpit::getHost);
            registry.add("spring.mail.port", () -> mailpit.getMappedPort(1025).toString());
            registry.add("nats.spring.server", () -> {
                String host = natsServer.getHost();
                Integer port = natsServer.getMappedPort(4222);
                return String.format("nats://%s:%d", host, port);
            });
        };
    }

    @Bean
    @ServiceConnection("redis")
    public RedisContainer redisContainer() {
        return new RedisContainer();
    }

    @Bean
    @ServiceConnection
    public PostgreSQLContainer<?> mysqlContainer() {
        return new PostgreSQLContainer<>("postgres:17.5");
    }
}
