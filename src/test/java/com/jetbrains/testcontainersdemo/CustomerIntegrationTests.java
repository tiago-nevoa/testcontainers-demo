package com.jetbrains.testcontainersdemo;

import java.io.IOException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.CassandraContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.output.OutputFrame;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CustomerIntegrationTests extends AbstractTest {

    @Autowired
    private CustomerDao customerDao;

//    @Container
//    private static CassandraContainer cassandraContainer = new CassandraContainer("cassandra:latest");

//    @DynamicPropertySource
//    static void overrideProps(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", cassandraContainer::getContainerName);
//        registry.add("spring.datasource.username", cassandraContainer::getUsername);
//        registry.add("spring.datasource.password", cassandraContainer::getPassword);
//    }

    @Test
    void when_using_a_clean_db_this_should_be_empty() throws IOException, InterruptedException {
//        mySQLContainer.withClasspathResourceMapping("application.properties", "/tmp/application.properties", BindMode.READ_ONLY);
//        mySQLContainer.withFileSystemBind("C:\\dev\\application.properties", "/tmp/bla.txt", BindMode.READ_ONLY);
//
//        mySQLContainer.execInContainer("ls", "-la");
//
//        mySQLContainer.getLogs(OutputFrame.OutputType.STDOUT);
//
//        Integer onYourMachine = mySQLContainer.getMappedPort(3306);

        List<Customer> customers = customerDao.findAll();
        assertThat(customers).hasSize(2);
    }

}
