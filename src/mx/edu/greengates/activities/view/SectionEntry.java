package mx.edu.greengates.activities.view;

import mx.edu.greengates.activities.model.*;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SectionEntry implements TableEntry {

    private JTable sectionTable;
    private JPanel sectionPanel;
    private JScrollPane scrollPane;
    private JButton addSectionButton;
    private JTextField textNewSection;

    public JPanel getPanel() {
        return sectionPanel;
    }

    public SectionEntry() {
        this.addSectionButton.addActionListener(addNewListener());
    }

    private ActionListener addNewListener(){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add New Section button clicked");
                SectionDao dao = new SectionDao();
                String name = textNewSection.getText();
                Section section = new Section(0, name);
                dao.save(section);
                textNewSection.setText("");
                Object[][] data = dao.getAllObjects();
                setTableData(data);
            }
        };
        return listener;
    }

    private void setTableData(Object[][] data) {
        sectionTable.setModel(new SectionTableModel(data));
        sectionTable.setFillsViewportHeight(true);
        TableColumnModel columnModel = sectionTable.getColumnModel();
        TableColumn idColumn = columnModel.getColumn(0);
        idColumn.setMinWidth(10);
        idColumn.setMaxWidth(30);
    }
    public void createUIComponents() {
        Dao dao = new SectionDao();
        String[] columnNames = dao.getColumNames();
        Object[][] data = dao.getAllObjects();
        sectionTable = new JTable();
        setTableData(data);
        scrollPane = new JScrollPane(sectionTable);
    }
}
