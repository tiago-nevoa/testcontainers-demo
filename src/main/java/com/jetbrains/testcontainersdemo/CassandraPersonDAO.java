package com.jetbrains.testcontainersdemo;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CassandraPersonDAO implements PersonDAO {
    private final CqlSession cqlSession;

    public CassandraPersonDAO(CqlSession cqlSession) {
        this.cqlSession = cqlSession;
    }

    @Override
    public void insertData(String id, String name) {
        String insertQuery = "INSERT INTO person (id, name) VALUES (?, ?)";
        cqlSession.execute(insertQuery, id, name);
    }

    @Override
    public String getData(String id) {
        String selectQuery = "SELECT name FROM person WHERE id = ?";
        return cqlSession.execute(selectQuery, id)
                .one()
                .getString("name");
    }

    @Override
    public List<Person> getAllPersons() {
        String selectQuery = "SELECT id, name FROM person";
        ResultSet resultSet = cqlSession.execute(selectQuery);

        List<Person> persons = new ArrayList<>();
        for (Row row : resultSet) {
            String id = row.getString("id");
            String name = row.getString("name");
            persons.add(new Person(id, name));
        }

        return persons;
    }
}
