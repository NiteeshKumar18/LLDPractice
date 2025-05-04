package CarRental;

public class Location {
    private final String state;
    private final String district;

    private final String city;
    private final String pinCode;

    public Location(String state, String district, String city, String pinCode) {
        this.state = state;
        this.district = district;
        this.city = city;
        this.pinCode = pinCode;
    }
}
