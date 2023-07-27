package com.jetbrains.testcontainersdemo;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

import java.util.List;

public interface PersonDAO {
    void insertData(String id, String name);
    String getData(String id);
    List<Person> getAllPersons();
}