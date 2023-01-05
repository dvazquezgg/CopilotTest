package mx.edu.greengates.activities.model;

public class YearType {
    /**
     * A POJO class that represents a year type.
     * it includes the year type's name and the number of activities
     *
     */

    private int id;
    private String year;

    public YearType(int id, String name) {
        this.id = id;
        this.year = name;
    }

    public int getId() {
        return id;
    }

    public String getYear() {
        return year;
    }

}
