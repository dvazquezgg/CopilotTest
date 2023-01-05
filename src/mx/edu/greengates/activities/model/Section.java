package mx.edu.greengates.activities.model;

public class Section {
    /**
     * A POJO class that represents a section.
     * it includes the section's name and the number of activities
     *
     */

    private int id;
    private String name;

    public Section(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}

