package org.mvnsearch.testcontainers.demo;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.spring.api.DBRider;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 * Spring Boot base test case with TestContainers suppoort
 *
 * @author linux_china
 */
@Import(TestContainersConfiguration.class)
@Testcontainers
@DBRider
@DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE, columnSensing = true)
public abstract class TestcontainersBaseTest extends SpringBootBaseTest {

}
