package mx.edu.greengates.activities.view;

import mx.edu.greengates.activities.model.*;
import mx.edu.greengates.activities.util.DbConnection;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.sql.Connection;

public class YearTypeEntry implements TableEntry {

    private JTable yearTypeTable;
    private JPanel yearTypePanel;
    private JScrollPane scrollPane;

    public JPanel getPanel() {
        return yearTypePanel;
    }

    public void createUIComponents() {
        DbConnection db = DbConnection.getInstance();
        Connection conn = db.getConnection();
        Dao dao = new YearTypeDao(conn);
        String[] columnNames = dao.getColumNames();
        Object[][] data = dao.getAllObjects();
        yearTypeTable = new JTable();
        yearTypeTable.setModel(new YearTypeTableModel(data));
        yearTypeTable.setFillsViewportHeight(true);
        TableColumnModel columnModel = yearTypeTable.getColumnModel();
        TableColumn idColumn = columnModel.getColumn(0);
        idColumn.setMinWidth(10);
        idColumn.setMaxWidth(30);
        scrollPane = new JScrollPane(yearTypeTable);
        db.closeConnection();
    }
}

