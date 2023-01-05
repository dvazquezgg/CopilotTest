package mx.edu.greengates.activities.model;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    /**
     * A DAO interface that defines the methods that will be implemented by the DAO classes
     */
    String[] getColumNames();
    void save(T t);
    void update(T t);
    void delete(T t);
    List<T> getAll();

    Object[][] getAllObjects();
    Optional<T> get(int id);
}

