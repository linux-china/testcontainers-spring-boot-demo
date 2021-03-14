package org.mvnsearch.testcontainers.demo;


import org.testcontainers.containers.GenericContainer;
import redis.clients.jedis.Jedis;

public class RedisContainer extends GenericContainer<RedisContainer> {

    public RedisContainer() {
        this("redis:6.2.1");
    }

    public RedisContainer(String dockerImageName) {
        super(dockerImageName);
        withExposedPorts(6379);
    }

    public Jedis getJedis() {
        return new Jedis(getContainerIpAddress(), getMappedPort(6379));
    }
}