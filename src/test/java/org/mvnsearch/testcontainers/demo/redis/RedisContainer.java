package org.mvnsearch.testcontainers.demo.redis;


import org.testcontainers.containers.GenericContainer;
import redis.clients.jedis.Jedis;

public class RedisContainer extends GenericContainer<RedisContainer> {

    public RedisContainer() {
        this("8.0.1-alpine3.21");
    }

    public RedisContainer(String dockerImageName) {
        super(dockerImageName);
        withExposedPorts(6379);
    }

    public Jedis getJedis() {
        return new Jedis(getHost(), getMappedPort(6379));
    }
}