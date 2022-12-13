package mx.edu.greengates.activities.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        cbSection = getComboBox(new String[]{"F1-F3", "F4-F5", "L6-U6", "Primary", "Secondary"});
        cbSection.setSelectedIndex(0);
    }
}
