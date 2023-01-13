package mx.edu.greengates.activities.view;

import mx.edu.greengates.activities.model.*;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusStopEntry implements TableEntry{
    private JPanel busStopPanel;
    private JTable tableBusStops;
    private JButton addNewButton;
    private JTextField textBusStop;
    private JScrollPane scrollPane;


    public JPanel getPanel() {
        return busStopPanel;
    }

    public BusStopEntry() {
        this.addNewButton.addActionListener(newBusOptionListener());
    }



    private ActionListener newBusOptionListener(){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add New Teacher button clicked");
                Dao dao = new BusOptionDao();
                String stop_code = textBusStop.getText();
                BusStop option = new BusStop(0, stop_code);
                dao.save(option);
                textBusStop.setText("");
                Object[][] data = dao.getAllObjects();
                setTableData(data);
            }
        };
        return listener;
    }
    public void createUIComponents() {
        Dao dao = new BusOptionDao();
        String[] columnNames = dao.getColumNames();
        Object[][] data = dao.getAllObjects();
        tableBusStops = new JTable();
        setTableData(data);
    }

    private void setTableData(Object[][] data) {
        tableBusStops.setModel(new BusStopTableModel(data));
        tableBusStops.setFillsViewportHeight(true);
        TableColumnModel columnModel = tableBusStops.getColumnModel();
        TableColumn idColumn = columnModel.getColumn(0);
        idColumn.setMinWidth(10);
        idColumn.setMaxWidth(30);
    }
}
