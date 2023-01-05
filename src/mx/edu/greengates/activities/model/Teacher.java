package mx.edu.greengates.activities.model;

public class Teacher {
    /**
     * A POJO class that represents a teacher.
     * it includes the teacher's name and the number of activities
     *
     */

    private int id;
    private String name;

    private int number_of_activities;

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setNumberOfActivities(int number_of_activities) {
        this.number_of_activities = number_of_activities;
    }

    public int getNumber_of_activities() {
        return number_of_activities;
    }
}
