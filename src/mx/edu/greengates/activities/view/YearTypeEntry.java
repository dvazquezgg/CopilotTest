package mx.edu.greengates.activities.view;

import mx.edu.greengates.activities.model.*;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YearTypeEntry implements TableEntry {

    private JTable yearTypeTable;
    private JPanel yearTypePanel;
    private JScrollPane scrollPane;
    private JButton AddYearButton;
    private JTextField textNewYear;

    public JPanel getPanel() {
        return yearTypePanel;
    }

    public YearTypeEntry() {
        this.AddYearButton.addActionListener(addNewListener());
    }

    public void createUIComponents() {
        Dao dao = new YearTypeDao();
        String[] columnNames = dao.getColumNames();
        Object[][] data = dao.getAllObjects();
        yearTypeTable = new JTable();
        setTableData(data);
        scrollPane = new JScrollPane(yearTypeTable);
    }

    private ActionListener addNewListener(){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add New Section button clicked");
                YearTypeDao dao = new YearTypeDao();
                String name = textNewYear.getText();
                YearType year_type = new YearType(0, name);
                dao.save(year_type);
                textNewYear.setText("");
                Object[][] data = dao.getAllObjects();
                setTableData(data);
            }
        };
        return listener;
    }

    private void setTableData(Object[][] data) {
        yearTypeTable.setModel(new SectionTableModel(data));
        yearTypeTable.setFillsViewportHeight(true);
        TableColumnModel columnModel = yearTypeTable.getColumnModel();
        TableColumn idColumn = columnModel.getColumn(0);
        idColumn.setMinWidth(10);
        idColumn.setMaxWidth(30);
    }
}

