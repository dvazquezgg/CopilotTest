package mx.edu.greengates.activities.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class YearTypeDao implements Dao<YearType> {
    /**
     * A DAO class that represents a year type.
     * it includes the year type's name and the number of activities
     *
     */

    Connection conn;

    public YearTypeDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(YearType yearType) {
        System.out.println("Saving year: " + yearType);
        String sql = "INSERT INTO Years (year) VALUES ('" + yearType.getYear() + "')";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(YearType yearType) {
        System.out.println("Updating year: " + yearType);
        String sql = "UPDATE Years SET year = '" + yearType.getYear() + "' WHERE id_year = " + yearType.getId();
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(YearType yearType) {
        System.out.println("Deleting year: " + yearType);
        String sql = "DELETE FROM Years WHERE id_year = " + yearType.getId();
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<YearType> getAll() {
        List<YearType> years = new ArrayList<YearType>();

        String sql = "SELECT id_year as id, year FROM Years";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                YearType year = new YearType(rs.getInt("id"), rs.getString("year"));
                years.add(year);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return years;
    }

    public String[] getColumNames() {
        String[] columnNames = {"id", "year"};
        return columnNames;
    }

    @Override
    public Optional<YearType> get(int id) {
        String sql = "SELECT id_year as id, year as years FROM Years WHERE id_year = " + id;
        try (Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("text"));
                return Optional.of(new YearType(rs.getInt("id"), rs.getString("years")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Object[][] getAllObjects() {
        List<YearType> years = getAll();
        Object[][] data = new Object[years.size()][2];
        for (int i = 0; i < years.size(); i++) {
            data[i][0] = years.get(i).getId();
            data[i][1] = years.get(i).getYear();
        }
        return data;
    }
}

