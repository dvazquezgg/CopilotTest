package mx.edu.greengates.activities.model;

import mx.edu.greengates.activities.util.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BusStopDao extends DaoImpl<BusStop> {
    /** A Dao class that represents a teacher.
     * it includes the teacher's name and the number of activities
     *
     */

    public BusStopDao() {    }

    @Override
    public void save(BusStop busStop) {
        System.out.println("Saving bus_stop: " + busStop);
        String sql = "INSERT INTO Bus_Stops (option_code, stop_code, arrival, stop) VALUES ('" + busStop.getOptionCode() + "', '" + busStop.getStopCode() + "', '" + busStop.getArrival() + "', '" + busStop.getStop() + "')";
        executeDBTransaction(sql);
    }

    @Override
    public void update(BusStop busStop) {
        System.out.println("Updating bus_stop: " + busStop);
        String sql = "UPDATE Bus_Stops SET option_code = '" + busStop.getOptionCode() + "'," +
                " stop_code = '"+ busStop.getStopCode() + "', " +
                " arrival = '" + busStop.getArrival() + "', " +
                " stop = '" + busStop.getStop() + "' WHERE id = " + busStop.getId();
        executeDBTransaction(sql);
    }

    @Override
    public void delete(BusStop busStop) {
        System.out.println("Deleting bus_stop: " + busStop);
        String sql = "DELETE FROM Bus_Stops WHERE id = " + busStop.getId();
        executeDBTransaction(sql);
    }

    @Override
    public List<BusStop> getAll() {
        Connection conn = getConnection();
        List<BusStop> busStops = new ArrayList<BusStop>();

        String sql = "SELECT id, option_code as option, stop_code, arrival, stop FROM Bus_Stops";

        try (Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("option") + "\t" +
                        rs.getString("stop_code") + "\t" +
                        rs.getString("arrival") + "\t" +
                        rs.getString("stop"));
                busStops.add(new BusStop(rs.getInt("id"), rs.getString("option"), rs.getString("stop_code"), rs.getString("arrival"), rs.getString("stop")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return busStops;

    }

    @Override
    public Optional<BusStop> get(int id) {
        Connection conn = getConnection();
        String sql = "SELECT id, option_code as option, stop_code, arrival, stop FROM Bus_Stops WHERE id = " + id;
        try (Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("option") + "\t" +
                        rs.getString("stop_code") + "\t" +
                        rs.getString("arrival") + "\t" +
                        rs.getString("stop"));
                return Optional.of(new BusStop(rs.getInt("id"), rs.getString("option"), rs.getString("stop_code"), rs.getString("arrival"), rs.getString("stop")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return Optional.empty();
    }


    public String[] getColumNames() {
        String[] names = {"id", "option_code", "stop_code", "arrival", "stop"};
        return names;
    }

    public Object[][] getAllObjects() {
        List<BusStop> busStops = getAll();
        Object[][] data = new Object[busStops.size()][getColumNames().length];
        for (int i = 0; i < busStops.size(); i++) {
            data[i][0] = busStops.get(i).getId();
            data[i][1] = busStops.get(i).getOptionCode();
            data[i][2] = busStops.get(i).getStopCode();
            data[i][3] = busStops.get(i).getArrival();
            data[i][4] = busStops.get(i).getStop();
        }
        return data;
    }
}
