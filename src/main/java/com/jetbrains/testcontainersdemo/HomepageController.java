package com.jetbrains.testcontainersdemo;

import com.datastax.oss.driver.api.core.CqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomepageController {

    private static final Logger logger = LoggerFactory.getLogger(HomepageController.class);

    @Autowired
    private CassandraPersonDAO cassandraPersonDAO;

    @GetMapping("/")
    public List<Person> persons() {
        List<Person> persons = cassandraPersonDAO.getAllPersons(); // Use the getAllPersons() method
        persons.forEach(p -> logger.info("Found a person: {}", p));
        return persons;
    }
}
