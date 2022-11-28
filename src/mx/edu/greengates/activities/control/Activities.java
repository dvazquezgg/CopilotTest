package mx.edu.greengates.activities.control;

public class Activities {
    /**
     * A POJO class that represents an activity.
     * it includes the activity's name, date, time, location, description and the number of students
     *
     */

    /* enumeration gender type: boys, girls, mixed
     */
    enum activity_gender{
        BOYS,
        GIRLS,
        BOTH
    }

    private String code;
    private String activity_name;
    private String day;
    private String section;
    private int gender_type;
    private String location;
    private String description;
    private int max_number_of_students;
    private int min_number_of_students;

    private String[] teachers;


    public Activities(String code,String activity_name, String day, String section, String location, int gender_type, String description, int number_of_students) {
        this.code = code;
        this.activity_name = activity_name;
        this.day = day;
        this.section = section;
        this.location = location;
        this.gender_type = gender_type;
        this.description = description;
        this.max_number_of_students = number_of_students;
        this.min_number_of_students = 0;
        this.teachers = new String[5];
    }

    public String getCode() {
        return code;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public String getDay() {
        return day;
    }


    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public int getMax_number_of_students() {
        return max_number_of_students;
    }

    public int getMin_number_of_students() {
        return min_number_of_students;
    }


    @Override
    public String toString() {
        return "Activities{" +
                "name='" + activity_name + '\'' +
                ", date='" + day + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", max_number_of_students=" + max_number_of_students +
                '}';
    }
}

