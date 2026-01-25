package ParkingLot;

public class ParkingSpot {
    private String spotId;
    private SpotType type;
    private boolean isOccupied;
    private Vehicle vehicle;
    private int floor;

    public ParkingSpot(String spotId, SpotType type, int floor) {
        this.spotId = spotId;
        this.type = type;
        this.floor = floor;
        this.isOccupied = false;
        this.vehicle = null;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        if (isOccupied) {
            return false;
        }

        switch (vehicle.getType()) {
            case MOTORCYCLE:
                return true; // Can park in any spot
            case CAR:
                return type == SpotType.COMPACT || type == SpotType.LARGE || type == SpotType.HANDICAPPED;
            case VAN:
                return type == SpotType.LARGE;
            case TRUCK:
                return type == SpotType.LARGE;
            default:
                return false;
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (canFitVehicle(vehicle)) {
            this.vehicle = vehicle;
            this.isOccupied = true;
            return true;
        }
        return false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isOccupied = false;
    }

    public String getSpotId() {
        return spotId;
    }

    public SpotType getType() {
        return type;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getFloor() {
        return floor;
    }
}

