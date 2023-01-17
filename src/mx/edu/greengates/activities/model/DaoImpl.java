package mx.edu.greengates.activities.model;

import mx.edu.greengates.activities.util.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

abstract class DaoImpl<T> implements Dao<T> {

    protected Connection getConnection() {
        DbConnection db = DbConnection.getInstance();
        Connection conn = db.getConnection();
        return conn;
    }

    protected void closeConnection() {
        DbConnection db = DbConnection.getInstance();
        db.closeConnection();
    }

    protected void executeDBTransaction(String sql) {
        Connection conn = getConnection();
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
    }

}
