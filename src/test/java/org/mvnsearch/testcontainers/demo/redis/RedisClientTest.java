package org.mvnsearch.testcontainers.demo.redis;

import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import redis.clients.jedis.Jedis;


@Testcontainers
public class RedisClientTest {

    @Container
    static RedisContainer redisContainer = new RedisContainer();

    @Test
    public void testOperations() {
        Jedis jedis = redisContainer.getJedis();
        jedis.set("nick", "leijuan");
        System.out.println(jedis.get("nick"));
    }
}
