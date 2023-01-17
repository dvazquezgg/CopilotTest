package mx.edu.greengates.activities.model;

public class BusOption {
    /**
     * A POJO class that represents a bus option.
     * it includes the bus_code, the bus_number, the route and bus_stop and the time of arrival
     *
     */

    private int id;
    private String option_code;
    private String route;

    public BusOption(int id, String option_code, String route) {
        this.id = id;
        this.option_code = option_code;
        this.route = route;
    }

    public int getId() {
        return id;
    }

    public String getRoute() {
        return route;
    }

    public String getOption_code() {
        return option_code;
    }

    @Override
    public String toString() {
        return "BusOption{" +
                "id='" + id + '\'' +
                ", option_code='" + option_code + '\'' +
                ", route='" + route + '\'' +
                '}';
    }
}
