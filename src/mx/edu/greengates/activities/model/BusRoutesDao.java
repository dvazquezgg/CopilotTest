package mx.edu.greengates.activities.model;

import java.util.List;
import java.util.Optional;

public class BusRoutesDao implements Dao<BusRoutes>{
    /**
     * A DAO class that implements the methods defined in the DAO interface
     */
    @Override
    public void save(BusRoutes busRoutes) {
        System.out.println("Saving busRoutes: " + busRoutes);
    }

    @Override
    public void update(BusRoutes busRoutes) {
        System.out.println("Updating busRoutes: " + busRoutes);
    }

    @Override
    public void delete(BusRoutes busRoutes) {
        System.out.println("Deleting busRoutes: " + busRoutes);
    }

    @Override
    public List<BusRoutes> getAll() {
        return null;
    }

    @Override
    public Optional<BusRoutes> get(int id) {
        return Optional.empty();
    }


}
