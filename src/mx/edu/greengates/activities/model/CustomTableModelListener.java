package mx.edu.greengates.activities.model;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class CustomTableModelListener implements TableModelListener  {

    /**
     * Create a private class that extends TableModelListener to handel table updates
     *
     * Created by dvazqueza on 04/01/2023
     */

        @Override
        public void tableChanged(TableModelEvent e) {
            int row = e.getFirstRow();
            int column = e.getColumn();
            TableModel model = (TableModel) e.getSource();
            String columnName = model.getColumnName(column);
            Object data = model.getValueAt(row, column);
            System.out.println("Table changed: " + columnName + " = " + data);
        }
}
