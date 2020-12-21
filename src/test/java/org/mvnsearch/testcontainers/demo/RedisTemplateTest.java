package org.mvnsearch.testcontainers.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Redis template test
 *
 * @author linux_china
 */
public class RedisTemplateTest extends SpringBootBaseTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testOperation() {
        redisTemplate.opsForValue().set("nick", "leijuan");
        System.out.println(redisTemplate.opsForValue().get("nick"));
    }
}
