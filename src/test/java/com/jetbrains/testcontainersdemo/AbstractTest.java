package com.jetbrains.testcontainersdemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.CassandraContainer;

public abstract class AbstractTest {

    private static final CassandraContainer cassandraContainer = (CassandraContainer) new CassandraContainer ("cassandra:latest")
            .withReuse(true);

    @DynamicPropertySource
    static void overrideProps(DynamicPropertyRegistry registry) {
        registry.add("spring.data.cassandra.contact-points", cassandraContainer::getContainerIpAddress);
        registry.add("spring.data.cassandra.port", () -> cassandraContainer.getMappedPort(9042));
    }

    @BeforeAll
    public static void setup() {
        cassandraContainer.start();
        cassandraContainer.withInitScript("people.cql");
    }

    @AfterAll
    public static void tearDown() {
        cassandraContainer.stop();
    }
}

