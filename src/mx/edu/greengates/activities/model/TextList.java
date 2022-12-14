package mx.edu.greengates.activities.model;

public class TextList {
    /**
     * A POJO class that represents a text item in a list.
     * it includes the activity's name, date, time, location, description and the number of students
     *
     */

    enum text_type{
        SECTION,
        YEARS
    }
    private String text;
    private int id;

    public TextList(String text, int id) {
        this.text = text;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return text;
    }
}
