package mx.edu.greengates.activities.model;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class ActivityDao implements Dao<Activity> {
    /**
     * A DAO class that implements the methods defined in the DAO interface
     */

    Connection con;

    ActivityDao(Connection con) {
        this.con = con;
    }

    @Override
    public String[] getColumNames() {
        return new String[0];
    }

    /**
     * A DAO class that implements the methods defined in the DAO interface
     */
    @Override
    public void save(Activity activity) {
        System.out.println("Saving activity: " + activity);
    }

    @Override
    public void update(Activity activity) {
        System.out.println("Updating activity: " + activity);
    }

    @Override
    public void delete(Activity activity) {
        System.out.println("Deleting activity: " + activity);
    }

    @Override
    public List<Activity> getAll() {
        return null;
    }

    @Override
    public Object[][] getAllObjects() {
        return new Object[0][];
    }

    @Override
    public Optional<Activity> get(int id) {
        return Optional.empty();
    }
}
