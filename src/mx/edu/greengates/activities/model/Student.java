package mx.edu.greengates.activities.model;

public class Student {
    /**
     * A POJO class that represents a student.
     * it includes the student's name, id, section, class and bus_number
     *
     */
    private String name;
    private int id;
    private String section;
    private String class_name;
    private String bus_number;

    private boolean isNewStudent;

    private String afternoon_bus_number;

    private String notes;

    private double bus_payment;

    private double other_payment;

    public Student(String name, int id, String section, String class_name, String bus_number) {
        this.name = name;
        this.id = id;
        this.section = section;
        this.class_name = class_name;
        this.bus_number = bus_number;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getSection() {
        return section;
    }

    public String getClass_name() {
        return class_name;
    }

    public String getBus_number() {
        return bus_number;
    }

    public String getAfternoon_bus_number() {
        return afternoon_bus_number;
    }

    public boolean isNewStudent() {
        return isNewStudent;
    }

    public String getNotes() {
        return notes;
    }

    public double getBus_payment() {
        return bus_payment;
    }

    public double getOther_payment() {
        return other_payment;
    }

    public void setNewStudent(boolean isNewStudent) {
        this.isNewStudent = isNewStudent;
    }

    public void setAfternoon_bus_number(String afternoon_bus_number) {
        this.afternoon_bus_number = afternoon_bus_number;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setBus_payment(double bus_payment) {
        this.bus_payment = bus_payment;
    }

    public void setOther_payment(double other_payment) {
        this.other_payment = other_payment;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", id=" + id + ", section=" + section + ", class_name=" + class_name + ", bus_number=" + bus_number + ", isNewStudent=" + isNewStudent + ", afternoon_bus_number=" + afternoon_bus_number + ", notes=" + notes + ", bus_payment=" + bus_payment + ", other_payment=" + other_payment + '}';
    }

}
