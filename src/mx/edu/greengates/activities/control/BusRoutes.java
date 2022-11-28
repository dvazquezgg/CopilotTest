package mx.edu.greengates.activities.control;

public class BusRoutes {
    /**
     * A POJO class that represents a bus route.
     * it includes the bus_code, the bus_number, the route and bus_stop and the time of arrival
     *
     */

    private String bus_code;
    private String bus_number;
    private String route;
    private String bus_stop;
    private String time_of_arrival;

    public BusRoutes(String bus_code, String bus_number, String route, String bus_stop, String time_of_arrival) {
        this.bus_code = bus_code;
        this.bus_number = bus_number;
        this.route = route;
        this.bus_stop = bus_stop;
        this.time_of_arrival = time_of_arrival;
    }

    public String getBus_code() {
        return bus_code;
    }

    public String getBus_number() {
        return bus_number;
    }

    public String getRoute() {
        return route;
    }

    public String getBus_stop() {
        return bus_stop;
    }

    public String getTime_of_arrival() {
        return time_of_arrival;
    }

    @Override
    public String toString() {
        return "BusRoutes{" +
                "bus_code='" + bus_code + '\'' +
                ", bus_number='" + bus_number + '\'' +
                ", route='" + route + '\'' +
                ", bus_stop='" + bus_stop + '\'' +
                ", time_of_arrival='" + time_of_arrival + '\'' +
                '}';
    }



}
