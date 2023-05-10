package org.mvnsearch.testcontainers.demo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Spring Boot base test case
 *
 * @author linux_china
 */
@SpringBootTest
@ActiveProfiles("test")
public abstract class SpringBootBaseTest {

}
