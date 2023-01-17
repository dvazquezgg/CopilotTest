package mx.edu.greengates.activities.view;

import mx.edu.greengates.activities.model.*;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusOptionEntry {
    private JPanel busOptionPanel;
    private JTable dataTable;
    private JButton addOptionButton;
    private JTextField textRoute;
    private JTextField textCode;
    private JScrollPane scrollPane;

    public JPanel getPanel() {
        return busOptionPanel;
    }

    public BusOptionEntry() {
        this.addOptionButton.addActionListener(newOptionListener());
    }

    private ActionListener newOptionListener(){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add New Teacher button clicked");
                BusOptionDao dao = new BusOptionDao();
                String code = textCode.getText();
                String route = textRoute.getText();
                BusOption option = new BusOption(0, code, route);
                dao.save(option);
                textCode.setText("");
                textCode.setText("");
                Object[][] data = dao.getAllObjects();
                setTableData(data);
            }
        };
        return listener;
    }
    public void createUIComponents() {
        BusOptionDao dao = new BusOptionDao();
        String[] columnNames = dao.getColumNames();
        Object[][] data = dao.getAllObjects();
        dataTable = new JTable();
        setTableData(data);
        scrollPane = new JScrollPane(dataTable);

    }

    private void setTableData(Object[][] data) {
        dataTable.setModel(new BusOptionTableModel(data));
        dataTable.setFillsViewportHeight(true);
        TableColumnModel columnModel = dataTable.getColumnModel();
        TableColumn idColumn = columnModel.getColumn(0);
        idColumn.setMinWidth(10);
        idColumn.setMaxWidth(30);
    }
}
