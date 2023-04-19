package org.mvnsearch.testcontainers.demo;

import org.springframework.boot.SpringApplication;

/**
 * Spring Boot Application with containers support
 *
 * @author linux_china
 */
public class SpringBootDemoTestApp {
    public static void main(String[] args) {
        SpringApplication
                .from(SpringBootDemoApp::main)
                .with(TestContainersConfiguration.class)
                .run(args);
    }
}
