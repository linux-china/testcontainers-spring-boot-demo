package org.mvnsearch.testcontainers.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Redis template test
 *
 * @author linux_china
 */
@SpringBootTest
public class JdbcTemplateTest extends TestcontainersBaseTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testOperation() {
        jdbcTemplate.query("select * from users", rs -> {
            System.out.println(rs.getString("email"));
        });
    }
}
