package org.mvnsearch.testcontainers.demo;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * Spring Boot base test case with TestContainers suppoort
 *
 * @author linux_china
 */
@SpringBootTest
@Import(TestContainersConfiguration.class)
@Testcontainers
public abstract class TestContainersBaseTest {

}
