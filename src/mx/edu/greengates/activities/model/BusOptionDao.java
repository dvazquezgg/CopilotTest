package mx.edu.greengates.activities.model;

import mx.edu.greengates.activities.util.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BusOptionDao implements Dao<BusOption> {
    /** A Dao class that represents a teacher.
     * it includes the teacher's name and the number of activities
     *
     */

    public BusOptionDao() {    }


    protected Connection getConnection() {
        DbConnection db = DbConnection.getInstance();
        Connection conn = db.getConnection();
        return conn;
    }


    protected void closeConnection() {
        DbConnection db = DbConnection.getInstance();
        db.closeConnection();
    }

    private void executeDBTransaction(String sql) {
        Connection conn = getConnection();
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
    }
    @Override
    public void save(BusOption busOption) {
        System.out.println("Saving teacher: " + busOption);
        String sql = "INSERT INTO Bus_Options (option_code, route) VALUES ('" + busOption.getOptionCode() + "', '" + busOption.getRoute() +"')";
        executeDBTransaction(sql);
    }

    @Override
    public void update(BusOption busOption) {
        System.out.println("Updating teacher: " + busOption);
        String sql = "UPDATE Bus_Options SET name = '" + busOption.getOptionCode() + "', route = '"+ busOption.getRoute() +"' WHERE id = " + busOption.getId();
        executeDBTransaction(sql);
    }

    @Override
    public void delete(BusOption busOption) {
        System.out.println("Deleting bus option: " + busOption);
        String sql = "DELETE FROM Teacher WHERE id = " + busOption.getId();
        executeDBTransaction(sql);
    }

    @Override
    public List<BusOption> getAll() {
        Connection conn = getConnection();
        List<BusOption> busOptions = new ArrayList<BusOption>();

        String sql = "SELECT id, option_code as code, route FROM Bus_Options";

        try (Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("code") + "\t" +
                                rs.getString("route"));
                busOptions.add(new BusOption(rs.getInt("id"), rs.getString("code"), rs.getString("route")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return busOptions;

    }

    @Override
    public Optional<BusOption> get(int id) {
        Connection conn = getConnection();
        String sql = "SELECT id,  option_code as code, route FROM Bus_Options WHERE id = " + id;
        try (Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("text"));
                return Optional.of(new BusOption(rs.getInt("id"), rs.getString("code"), rs.getString("route")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return Optional.empty();
    }


    public String[] getColumNames() {
        String[] names = {"id", "option_code", "route"};
        return names;
    }

    public Object[][] getAllObjects() {
        List<BusOption> busOptions = getAll();
        Object[][] data = new Object[busOptions.size()][3];
        for (int i = 0; i < busOptions.size(); i++) {
            data[i][0] = busOptions.get(i).getId();
            data[i][1] = busOptions.get(i).getOptionCode();
            data[i][2] = busOptions.get(i).getRoute();
        }
        return data;
    }
}
