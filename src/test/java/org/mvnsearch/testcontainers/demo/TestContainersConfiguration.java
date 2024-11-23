package org.mvnsearch.testcontainers.demo;

import org.mvnsearch.testcontainers.demo.redis.RedisContainer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistrar;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

@SuppressWarnings("resource")
@TestConfiguration(proxyBeanMethods = false)
public class TestContainersConfiguration {

    @Container
    static GenericContainer<?> mailpit = new GenericContainer<>("axllent/mailpit:v1.20.4").withExposedPorts(1025, 8025);
    @Container
    static GenericContainer<?> natsServer = new GenericContainer<>("nats:2.10.22-alpine").withExposedPorts(4222);

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
    public MySQLContainer<?> mysqlContainer() {
        return new MySQLContainer<>("mysql:8.0.33").withReuse(true);
    }
}
