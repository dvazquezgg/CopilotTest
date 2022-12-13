import mx.edu.greengates.activities.model.Activity;
import mx.edu.greengates.activities.util.DbConnection;
import mx.edu.greengates.activities.view.ActivityEntry;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        DbConnection db = new DbConnection();
        List<Activity> activities = db.selectActivities();

        for (Activity activity : activities) {
            System.out.println(activity.getActivity_name());
        }

        //Activity activity =activities.get(0);
        //db.insertActivity(activity);
        displayActivityForm();

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
}