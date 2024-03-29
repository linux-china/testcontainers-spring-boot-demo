package org.mvnsearch.testcontainers.demo.redis;

import org.junit.jupiter.api.Test;
import org.mvnsearch.testcontainers.demo.TestcontainersBaseTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Redis template test
 *
 * @author linux_china
 */
@SpringBootTest
public class RedisTemplateTest extends TestcontainersBaseTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void testOperation() {
        redisTemplate.opsForValue().set("nick", "leijuan33");
        System.out.println(redisTemplate.opsForValue().get("nick"));
    }
}
