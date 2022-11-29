package mx.edu.greengates.activities.model;

import java.util.List;
import java.util.Optional;

public class StudentDao implements Dao<Student> {
    /**
     * A DAO class that implements the methods defined in the DAO interface
     */
    @Override
    public void save(Student student) {
        System.out.println("Saving student: " + student);
    }

    @Override
    public void update(Student student) {
        System.out.println("Updating student: " + student);
    }

    @Override
    public void delete(Student student) {
        System.out.println("Deleting student: " + student);
    }

    @Override
    public List<Student> getAll() {
        return null;
    }

    @Override
    public Optional<Student> get(int id) {
        return Optional.empty();
    }
}

