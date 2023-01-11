package mx.edu.greengates.activities.model;

import mx.edu.greengates.activities.util.DbConnection;

import java.sql.Connection;
import java.util.LinkedList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


public class TeacherTableModel implements TableModel {
    private String[] columnNames = {"ID", "Teacher Name"};
    private Object[][] data;

    private LinkedList suscribers = new LinkedList();

    public TeacherTableModel(Object[][] data) {
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

        TeacherDao dao = new TeacherDao();
        Teacher teacher = new Teacher((int) data[row][0], (String) data[row][1]);
        dao.update(teacher);
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



