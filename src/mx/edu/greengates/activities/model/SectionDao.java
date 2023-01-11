package mx.edu.greengates.activities.model;

import mx.edu.greengates.activities.util.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SectionDao implements Dao<Section> {
    /** A Dao class that represents a section.
     * it includes the section's name and the number of activities
     *
     */

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
    public SectionDao() {    }

    @Override
    public void save(Section section) {
        System.out.println("Saving section: " + section);
        String sql = "INSERT INTO Section (section_name) VALUES ('" + section.getName() + "')";
        executeDBTransaction(sql);
    }

    @Override
    public void update(Section section) {
        System.out.println("Updating section: " + section);
        String sql = "UPDATE Section SET section_name = '" + section.getName() + "' WHERE section_id = " + section.getId();
        executeDBTransaction(sql);
    }

    @Override
    public void delete(Section section) {
        System.out.println("Deleting section: " + section);
        String sql = "DELETE FROM Section WHERE section_id = " + section.getId();
        executeDBTransaction(sql);
    }

    @Override
    public List<Section> getAll() {
        List<Section> sections = new ArrayList<Section>();

        String sql = "SELECT section_id as id, section_name as section FROM Section";
        Connection conn = getConnection();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Section section = new Section(rs.getInt("id"), rs.getString("section"));
                sections.add(section);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return sections;
    }

    @Override
    public String[] getColumNames() {
        String[] columnNames = {"id", "section"};
        return columnNames;
    }

    @Override
    public Optional<Section> get(int id) {
        String sql = "SELECT section_id as id, section_name as section FROM Section WHERE section_id = " + id;
        Connection conn = getConnection();
        try (Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("section"));
                return Optional.of(new Section(rs.getInt("id"), rs.getString("section")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return Optional.empty();
    }

    @Override
    public Object[][] getAllObjects() {
        List<Section> sections = getAll();
        Object[][] data = new Object[sections.size()][2];
        for (int i = 0; i < sections.size(); i++) {
            data[i][0] = sections.get(i).getId();
            data[i][1] = sections.get(i).getName();
        }
        return data;
    }

}
