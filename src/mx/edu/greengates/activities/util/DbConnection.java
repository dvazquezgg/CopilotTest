package mx.edu.greengates.activities.util;

// Java Program to Retrieve Contents of a Table Using JDBC
// connection

// Showing linking of created database

// Importing SQL libraries to create database
import mx.edu.greengates.activities.model.Activity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnection {

    Connection con = null;

    public static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:AfternoonActivities.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    /**
     * select all rows in the a table
     */
    public List<Activity> selectActivities() {
        String sql = "SELECT " +
                "CODE," +
                "Day," +
                "Section," +
                "Activity," +
                "Venue," +
                "Years," +
                "Boys_Girls," +
                "MinNumber," +
                "MaxNumber," +
                "Teacher1," +
                "Teacher2," +
                "Teacher3," +
                "Teacher4," +
                "Teacher5," +
                "COST" +
                " FROM Activities";

        ArrayList<Activity> activities = new ArrayList<Activity>();

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                String code = rs.getString("CODE");
                String activity_name= rs.getString("Activity");
                String day= rs.getString("Day");
                String section= rs.getString("Section");
                String location= rs.getString("Venue");
                int gender_type= 0;
                String description= "";
                int number_of_students= rs.getInt("MaxNumber");

                Activity activity = new Activity(code, activity_name, day, section, location, gender_type, description, number_of_students);
                activities.add(activity);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return activities;
    }

    public int insertActivity(Activity  activity){

        // create a SQlite insert Recordset from activity
        String sqlInsert = "INSERT INTO Activities (CODE, Day, Section, Activity, Venue, Years, Boys_Girls," +
                " MinNumber, MaxNumber, Teacher1, Teacher2, Teacher3, Teacher4, Teacher5, COST) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        int records = 0;
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sqlInsert)) {
            pstmt.setString(1, activity.getCode());
            pstmt.setString(2, activity.getDay());
            pstmt.setString(3, activity.getSection());
            pstmt.setString(4, activity.getActivity_name());
            pstmt.setString(5, activity.getLocation());
            pstmt.setInt(6, activity.getGender_type());
            pstmt.setString(7, activity.getDescription());
            pstmt.setString(8, String.valueOf(activity.getMin_number_of_students()));
            pstmt.setString(9, String.valueOf(activity.getMax_number_of_students()));
            pstmt.setString(10, activity.getTeachers()[0]);
            pstmt.setString(11, activity.getTeachers()[1]);
            pstmt.setString(12, activity.getTeachers()[2]);
            pstmt.setString(13, activity.getTeachers()[3]);
            pstmt.setString(14, activity.getTeachers()[4]);
            pstmt.setInt(15, 0);

            records = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return records;
    }

    /**
     * select all rows in the Students table
     */
    public void selectAll(){
        String sql = "SELECT id, StudentIDNumber, StudentsName FROM Students";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getInt("StudentIDNumber") + "\t" +
                        rs.getString("StudentsName"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
