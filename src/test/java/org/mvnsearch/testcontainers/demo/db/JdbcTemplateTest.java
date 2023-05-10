package org.mvnsearch.testcontainers.demo.db;

import com.github.database.rider.core.api.dataset.DataSet;
import org.junit.jupiter.api.Test;
import org.mvnsearch.testcontainers.demo.TestcontainersBaseTest;
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
    @DataSet("db/datasets/users.xml")
    public void testOperation() {
        jdbcTemplate.query("select * from users", rs -> {
            System.out.println(rs.getString("email"));
        });
    }
}
