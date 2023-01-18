package mx.edu.greengates.activities.view;

import mx.edu.greengates.activities.model.*;
import mx.edu.greengates.activities.util.DbConnection;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class BusStopEntry implements TableEntry{
    private JPanel busStopPanel;
    private JTable dataTable;
    private JButton addNewButton;


    private JTextField textStopCode;
    private JTextField textArrival;
    private JTextField textStop;
    private JScrollPane scrollPane;
    private JComboBox cbOptionCode;


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
                System.out.println("Add New Bus Stop button clicked");
                Dao dao = new BusStopDao();
                String optionCode = (String) cbOptionCode.getSelectedItem();
                String stopCode = textStopCode.getText();
                String arrival = textArrival.getText();
                String stop = textStop.getText();
                BusStop option = new BusStop(0, optionCode, stopCode, arrival, stop);
                dao.save(option);
                cbOptionCode.setSelectedIndex(0);
                textStopCode.setText("");
                textArrival.setText("");
                textStop.setText("");
                Object[][] data = dao.getAllObjects();
                setTableData(data);
            }
        };
        return listener;
    }

    private JComboBox getComboBox(String[] items){
        JComboBox comboBox = new JComboBox(items);
        return comboBox;
    }

    public void createUIComponents() {
        BusOptionDao optionsDao = new BusOptionDao();
        String[] columnOptionNames = optionsDao.getColumNames();
        String[] options = optionsDao.getAll().stream().map(BusOption::getOption_code).toArray(String[]::new);

        cbOptionCode = getComboBox(options);


        Dao dao = new BusStopDao();
        String[] columnNames = dao.getColumNames();
        Object[][] data = dao.getAllObjects();

        dataTable = new JTable();
        setTableData(data);
        scrollPane = new JScrollPane(dataTable);
    }

    private void setTableData(Object[][] data) {
        dataTable.setModel(new BusStopTableModel(data));
        dataTable.setFillsViewportHeight(true);
        TableColumnModel columnModel = dataTable.getColumnModel();
        TableColumn idColumn = columnModel.getColumn(0);
        idColumn.setMinWidth(10);
        idColumn.setMaxWidth(30);
    }
}
