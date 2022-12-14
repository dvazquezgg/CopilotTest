package mx.edu.greengates.activities.model;

import mx.edu.greengates.activities.util.DbConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TextListDao implements Dao<TextList>{
    /**
     * A DAO class that implements the methods defined in the DAO interface
     */


    Connection conn;

    public TextListDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(TextList list) {
        System.out.println("Saving activity: " + list);
    }

    @Override
    public void update(TextList list) {
        System.out.println("Updating activity: " + list);
    }

    @Override
    public void delete(TextList list) {
        System.out.println("Deleting activity: " + list);
    }

    @Override
    public List<TextList> getAll() {
        return null;
    }

    public List<TextList> getAll(String type) {
        List<TextList> textlist = new ArrayList<TextList>();

        String sql;
        if (type.compareTo("SECTIONS") == 0) {
            sql = "SELECT section_id as id, section_name as text FROM Section";
        } else if (type.compareTo("YEARS") == 0) {
            sql = "SELECT id_year as id, year as text FROM Years";
        } else {
            sql = "";
        }

        try (Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("text"));
                textlist.add(new TextList(rs.getString("text"), rs.getInt("id")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return textlist;
    }

    @Override
    public Optional<TextList> get(int id) {
        return Optional.empty();
    }

}
