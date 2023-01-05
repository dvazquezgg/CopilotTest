package mx.edu.greengates.activities.view;

import mx.edu.greengates.activities.model.*;
import mx.edu.greengates.activities.util.DbConnection;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.sql.Connection;

public class SectionEntry implements TableEntry {

    private JTable sectionTable;
    private JPanel sectionPanel;
    private JScrollPane scrollPane;

    public JPanel getPanel() {
        return sectionPanel;
    }

    public void createUIComponents() {
        DbConnection db = DbConnection.getInstance();
        Connection conn = db.getConnection();
        Dao dao = new SectionDao(conn);
        String[] columnNames = dao.getColumNames();
        Object[][] data = dao.getAllObjects();
        sectionTable = new JTable();
        sectionTable.setModel(new SectionTableModel(data));
        sectionTable.setFillsViewportHeight(true);
        TableColumnModel columnModel = sectionTable.getColumnModel();
        TableColumn idColumn = columnModel.getColumn(0);
        idColumn.setMinWidth(10);
        idColumn.setMaxWidth(30);
        scrollPane = new JScrollPane(sectionTable);
        db.closeConnection();
    }
}
