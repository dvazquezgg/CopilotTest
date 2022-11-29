import mx.edu.greengates.activities.model.Activity;
import mx.edu.greengates.activities.util.DbConnection;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        DbConnection db = new DbConnection();
        List<Activity> activities = db.selectActivities();

        for (Activity activity : activities) {
            System.out.println(activity.getActivity_name());
        }

        Activity activity =activities.get(0);
        db.insertActivity(activity);

    }
}