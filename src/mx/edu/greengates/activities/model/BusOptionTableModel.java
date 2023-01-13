package mx.edu.greengates.activities.model;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.LinkedList;


public class BusOptionTableModel implements TableModel {
    private String[] columnNames = {"ID", "Option Code", "Route"};
    private Object[][] data;

    private LinkedList suscribers = new LinkedList();

    public BusOptionTableModel(Object[][] data) {
        this.data = data;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public boolean isCellEditable(int row, int col) {
        // return true if cell belongs to the second column and makes it editable, otherwise false
        return col==1;
    }

    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;

        Dao dao = new BusStopDao();
        BusOption busOption = new BusOption((int) data[row][0], (String) data[row][1],(String) data[row][2]);
        dao.update(busOption);
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        suscribers.add(new CustomTableModelListener());
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        suscribers.remove(l);
    }
}



