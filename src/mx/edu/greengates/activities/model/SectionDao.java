package mx.edu.greengates.activities.model;

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
    Connection conn;

    public SectionDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(Section section) {
        System.out.println("Saving section: " + section);
        String sql = "INSERT INTO Section (section_name) VALUES ('" + section.getName() + "')";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Section section) {
        System.out.println("Updating section: " + section);
        String sql = "UPDATE Section SET section_name = '" + section.getName() + "' WHERE section_id = " + section.getId();
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Section section) {
        System.out.println("Deleting section: " + section);
        String sql = "DELETE FROM Section WHERE section_id = " + section.getId();
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Section> getAll() {
        List<Section> sections = new ArrayList<Section>();

        String sql = "SELECT section_id as id, section_name as section FROM Section";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Section section = new Section(rs.getInt("id"), rs.getString("section"));
                sections.add(section);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
