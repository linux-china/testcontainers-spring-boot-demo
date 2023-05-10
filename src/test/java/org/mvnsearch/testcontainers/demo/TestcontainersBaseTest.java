package org.mvnsearch.testcontainers.demo;

import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * Spring Boot base test case with TestContainers suppoort
 *
 * @author linux_china
 */
@Import(TestContainersConfiguration.class)
@Testcontainers
public abstract class TestcontainersBaseTest extends SpringBootBaseTest {

}
