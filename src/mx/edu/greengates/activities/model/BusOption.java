package mx.edu.greengates.activities.model;

public class BusOption {
    /**
     * A POJO class that represents a bus option.
     * it includes the teacher's name and the number of activities
     *
     */

    private int id;
    private String optionCode;
    private String route;


    public BusOption(int id, String optionCode, String route) {
        this.id = id;
        this.optionCode = optionCode;
        this.route = route;
    }

    public int getId() {
        return id;
    }

    public String getOptionCode() {
        return optionCode;
    }

    public String getRoute() {
        return route;
    }


}
