package com.jetbrains.testcontainersdemo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CassandraIntegrationTest extends AbstractTest {

    @Autowired
    private PersonDAO personDAO;

    @Test
    public void testInsertAndGetData() {

        personDAO.insertData("some_key", "some_value");
        String value = personDAO.getData("some_key");
        assertEquals("some_value", value);
    }
}
