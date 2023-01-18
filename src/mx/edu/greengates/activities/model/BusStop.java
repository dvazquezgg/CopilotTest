package mx.edu.greengates.activities.model;

public class BusStop {
    /**
     * A POJO class that represents a bus stop.
     * it includes the teacher's name and the number of activities
     *
     */

    private int id;
    private String optionCode;
    private String stopCode;
    private String arrival;
    private String stop;

    public BusStop(int id, String optionCode, String stopCode, String arrival, String stop) {
        this.id = id;
        this.optionCode = optionCode;
        this.stopCode = stopCode;
        this.arrival = arrival;
        this.stop = stop;
    }

    public int getId() {
        return id;
    }

    public String getOptionCode() {
        return optionCode;
    }

    public String getStopCode() {
        return stopCode;
    }

    public String getArrival() {
        return arrival;
    }

    public String getStop() {
        return stop;
    }
}
