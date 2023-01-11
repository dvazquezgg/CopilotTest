package mx.edu.greengates.activities.view;

import mx.edu.greengates.activities.model.Teacher;
import mx.edu.greengates.activities.model.TeacherDao;
import mx.edu.greengates.activities.model.TeacherTableModel;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherEntry implements TableEntry {
    private JTable teacherTable;
    private JPanel teacherPanel;
    private JScrollPane scrollPane;
    private JButton addButton;
    private JTextField textNewTeacher;

    public JPanel getPanel() {
        return teacherPanel;
    }

    public TeacherEntry() {
        this.addButton.addActionListener(newTeacherListener());
    }

    private ActionListener newTeacherListener(){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add New Teacher button clicked");
                TeacherDao dao = new TeacherDao();
                String teacher_name = textNewTeacher.getText();
                Teacher teacher = new Teacher(0, teacher_name);
                dao.save(teacher);
                textNewTeacher.setText("");
                Object[][] data = dao.getAllObjects();
                setTableData(data);
            }
        };
        return listener;
    }
    public void createUIComponents() {
        TeacherDao dao = new TeacherDao();
        String[] columnNames = dao.getColumNames();
        Object[][] data = dao.getAllObjects();
        teacherTable = new JTable();
        setTableData(data);
        scrollPane = new JScrollPane(teacherTable);

    }

    private void setTableData(Object[][] data) {
        teacherTable.setModel(new TeacherTableModel(data));
        teacherTable.setFillsViewportHeight(true);
        TableColumnModel columnModel = teacherTable.getColumnModel();
        TableColumn idColumn = columnModel.getColumn(0);
        idColumn.setMinWidth(10);
        idColumn.setMaxWidth(30);
    }
}
