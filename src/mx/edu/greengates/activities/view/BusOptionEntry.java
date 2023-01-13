package mx.edu.greengates.activities.view;

import mx.edu.greengates.activities.model.*;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusOptionEntry implements TableEntry{
    private JPanel busOptionPanel;
    private JTable tableBusOptions;
    private JButton addOptionButton;
    private JTextField textRoute;
    private JTextField textCode;
    private JScrollPane scrollPane;


    public JPanel getPanel() {
        return busOptionPanel;
    }

    public BusOptionEntry() {
        this.addOptionButton.addActionListener(newBusOptionListener());
    }

    private void setTableData(Object[][] data) {
        tableBusOptions.setModel(new BusOptionTableModel(data));
        tableBusOptions.setFillsViewportHeight(true);
        TableColumnModel columnModel = tableBusOptions.getColumnModel();
        TableColumn idColumn = columnModel.getColumn(0);
        idColumn.setMinWidth(10);
        idColumn.setMaxWidth(30);
    }

    private ActionListener newBusOptionListener(){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add New Teacher button clicked");
                Dao dao = new BusOptionDao();
                String option_code = textCode.getText();
                String route = textRoute.getText();
                BusOption option = new BusOption(0, option_code, route);
                dao.save(option);
                textCode.setText("");
                textRoute.setText("");
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
        tableBusOptions = new JTable();
        setTableData(data);
        scrollPane = new JScrollPane(tableBusOptions);
    }
}
