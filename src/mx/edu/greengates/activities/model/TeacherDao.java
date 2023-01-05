package mx.edu.greengates.activities.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeacherDao implements Dao<Teacher> {
    /** A Dao class that represents a teacher.
     * it includes the teacher's name and the number of activities
     *
     */
    Connection conn;

    public TeacherDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(Teacher teacher) {
        System.out.println("Saving teacher: " + teacher);
        String sql = "INSERT INTO Teacher (teacher_name) VALUES ('" + teacher.getName() + "')";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Teacher teacher) {
        System.out.println("Updating teacher: " + teacher);
        String sql = "UPDATE Teacher SET teacher_name = '" + teacher.getName() + "' WHERE id = " + teacher.getId();
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Teacher teacher) {
        System.out.println("Deleting teacher: " + teacher);
        String sql = "DELETE FROM Teacher WHERE id = " + teacher.getId();
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Teacher> getAll() {
        List<Teacher> teachers = new ArrayList<Teacher>();

        String sql = "SELECT id, teacher_name as teacher FROM Teacher";

        try (Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("teacher"));
                teachers.add(new Teacher(rs.getInt("id"), rs.getString("teacher")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return teachers;

    }

    @Override
    public Optional<Teacher> get(int id) {
        String sql = "SELECT id, teacher_name as teacher FROM Teacher WHERE id = " + id;
        try (Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("text"));
                return Optional.of(new Teacher(rs.getInt("id"), rs.getString("text")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }


    public String[] getColumNames() {
        String[] names = {"id", "teacher_name"};
        return names;
    }

    public Object[][] getAllObjects() {
        List<Teacher> teachers = getAll();
        Object[][] data = new Object[teachers.size()][2];
        for (int i = 0; i < teachers.size(); i++) {
            data[i][0] = teachers.get(i).getId();
            data[i][1] = teachers.get(i).getName();
        }
        return data;
    }
}
