package CabBooking;

public class Location {

    public long latitude;
    public long longitude;

    public Location(long latitude, long longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long distanceTo(Location other) {
        double latDiff = this.latitude - other.latitude;
        double lonDiff = this.longitude - other.longitude;
        return (long) Math.sqrt(latDiff * latDiff + lonDiff * lonDiff);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
