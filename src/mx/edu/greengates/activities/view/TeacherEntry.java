package mx.edu.greengates.activities.view;

import mx.edu.greengates.activities.model.TeacherDao;
import mx.edu.greengates.activities.model.TeacherTableModel;
import mx.edu.greengates.activities.util.DbConnection;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.sql.Connection;

public class TeacherEntry implements TableEntry {
    private JTable teacherTable;
    private JPanel teacherPanel;
    private JScrollPane scrollPane;

    public JPanel getPanel() {
        return teacherPanel;
    }

    public void createUIComponents() {
        DbConnection db = DbConnection.getInstance();
        Connection conn = db.getConnection();
        TeacherDao dao = new TeacherDao(conn);
        String[] columnNames = dao.getColumNames();
        Object[][] data = dao.getAllObjects();
        teacherTable = new JTable();
        teacherTable.setModel(new TeacherTableModel(data));
        teacherTable.setFillsViewportHeight(true);
        TableColumnModel columnModel = teacherTable.getColumnModel();
        TableColumn idColumn = columnModel.getColumn(0);
        idColumn.setMinWidth(10);
        idColumn.setMaxWidth(30);
        scrollPane = new JScrollPane(teacherTable);
        db.closeConnection();

    }
}
