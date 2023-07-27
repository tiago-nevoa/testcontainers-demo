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

    @Test
    void when_using_a_clean_db_this_should_be_empty() {

        List<Customer> customers = customerDao.findAll();
        assertThat(customers).hasSize(2);
    }

}
