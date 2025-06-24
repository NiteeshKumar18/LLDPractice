package CabBooking;

public class Cab {

    private final int cabId;
    private final String cabNo;
    private final String cabName;
    private Location location;
    private final CabRider rider;
    private boolean isAvailable;


    public Cab(int cabId, String cabNo, String cabName, Location location, CabRider rider) {
        this.cabId = cabId;
        this.cabNo = cabNo;
        this.cabName = cabName;
        this.location = location;
        this.rider = rider;
    }

    // Getters for all fields

    public String getCabId() {
        return String.valueOf(cabId);
    }

    public String getCabNo() {
        return cabNo;
    }

    public String getCabName() {
        return cabName;
    }

    public Location getLocation() {
        return location;
    }

    public CabRider getRider() {
        return rider;
    }

    public boolean isAvailable() { // For boolean fields, getter typically starts with 'is'
        return isAvailable;
    }

    // Setters for mutable fields (non-final fields)
    // Fields declared as 'final' cannot have setters because their value can only be set once,
    // usually during object construction.

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


}
