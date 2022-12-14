package mx.edu.greengates.activities.view;

import mx.edu.greengates.activities.model.Dao;
import mx.edu.greengates.activities.model.TextList;
import mx.edu.greengates.activities.model.TextListDao;
import mx.edu.greengates.activities.util.DbConnection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class ActivityEntry {
    private JButton submitButton;
    private JLabel lblDayOfWeek;
    private JLabel lblSection;
    private JComboBox cbDayOfWeek;
    private JComboBox cbSection;
    private JComboBox cbVenue;
    private JLabel lblVenue;
    private JButton cancelButton;
    private JLabel lblYears;
    private JLabel lblBoysGirls;
    private JComboBox cbYears;
    private JLabel lblActivity;
    private JTextField txtActivity;
    private JCheckBox chkGirls;
    private JCheckBox chkBoys;
    private JPanel activityPanel;
    private JPanel buttonPanel;

    public JPanel getActivityPanel() {
        return activityPanel;
    }

    public ActivityEntry() {
        this.submitButton.addActionListener(submitListener());
        this.cancelButton.addActionListener(cancelListener());
    }

    private ActionListener cancelListener(){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cancel button clicked");
                txtActivity.setText("");
            }
        };
         return listener;
    }
    private ActionListener submitListener(){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Submit button clicked");
                System.out.println("Activity: " + txtActivity.getText());
                System.out.println("Day of week: " + cbDayOfWeek.getSelectedItem());
                System.out.println("Section: " + cbSection.getSelectedItem());
                System.out.println("Venue: " + cbVenue.getSelectedItem());
                System.out.println("Years: " + cbYears.getSelectedItem());
            }
        };
        return listener;
    }

    private JComboBox getComboBox(String[] items){
        JComboBox comboBox = new JComboBox(items);
        return comboBox;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        submitButton = new JButton("Submit");
        cancelButton = new JButton("Cancel");
        cbDayOfWeek = getComboBox(new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"});
        cbDayOfWeek.setSelectedIndex(0);

        DbConnection dbConnection = DbConnection.getInstance();
        Connection conn = dbConnection.getConnection();
        TextListDao textListDao = new TextListDao(conn);
        String[] years = textListDao.getAll("YEARS").stream().map(TextList::getText).toArray(String[]::new);
        String[] sections = textListDao.getAll("SECTIONS").stream().map(TextList::getText).toArray(String[]::new);
        dbConnection.closeConnection();

        cbYears = getComboBox(years);
        cbYears.setSelectedIndex(0);
        cbSection = getComboBox(sections);
        cbSection.setSelectedIndex(0);
    }
}
