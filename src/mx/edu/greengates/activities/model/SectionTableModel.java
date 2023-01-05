package mx.edu.greengates.activities.model;

import mx.edu.greengates.activities.util.DbConnection;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.Connection;

public class SectionTableModel implements TableModel {
    private Object[][] data;
    private final String[] columnNames = {"ID", "Section"};

    public SectionTableModel(Object[][] data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public boolean isCellEditable(int row, int col) {
        // return true if cell belongs to the second column and makes it editable, otherwise false
        return col==1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;

        DbConnection dbConnection = DbConnection.getInstance();
        Connection conn = dbConnection.getConnection();
        SectionDao dao = new SectionDao(conn);
        Section section = new Section((int) data[row][0], (String) data[row][1]);
        dao.update(section);
        dbConnection.closeConnection();
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}

