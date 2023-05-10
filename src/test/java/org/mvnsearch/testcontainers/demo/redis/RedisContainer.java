package org.mvnsearch.testcontainers.demo.redis;


import org.testcontainers.containers.GenericContainer;
import redis.clients.jedis.Jedis;

public class RedisContainer extends GenericContainer<RedisContainer> {

    public RedisContainer() {
        this("redis:7.0.10");
    }

    public RedisContainer(String dockerImageName) {
        super(dockerImageName);
        withExposedPorts(6379);
    }

    public Jedis getJedis() {
        return new Jedis(getHost(), getMappedPort(6379));
    }
}