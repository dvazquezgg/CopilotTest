import mx.edu.greengates.activities.model.Activity;
import mx.edu.greengates.activities.model.BusStop;
import mx.edu.greengates.activities.util.DbConnection;
import mx.edu.greengates.activities.view.*;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("-- Main function --");

        DbConnection db = DbConnection.getInstance();

        // List<Activity> activities = db.selectActivities();

        //for (Activity activity : activities) {
        //    System.out.println(activity.getActivity_name());
        // }

        //Activity activity =activities.get(0);
        //db.insertActivity(activity);
        //displayActivityForm();
        //displayTableForm(new TeacherEntry(), "Teachers");
        //displayTableForm(new SectionEntry(), "Sections");
        //displayTableForm(new YearTypeEntry(), "Years");
        //displayBusOptionsForm();
        displayBusStopForm();

    }

    private static void displayBusOptionsForm() {
        JFrame frame = new JFrame("Bus Options");
        frame.setContentPane(new BusOptionEntry().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private static void displayBusStopForm() {
        JFrame frame = new JFrame("Bus Stops");
        frame.setContentPane(new BusStopEntry().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void displayActivityForm(){
        System.out.println("Displaying activity form");
        JFrame frame = new JFrame("Input New Activity Information");
        ActivityEntry activities = new ActivityEntry();
        JPanel panel = activities.getActivityPanel();
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void displayTableForm(TableEntry entry, String title){
        System.out.println("Displaying teacher table form");
        JFrame frame = new JFrame(title);
        TableEntry table = entry;
        JPanel panel = table.getPanel();
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }




}