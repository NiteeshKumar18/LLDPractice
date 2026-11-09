package CarRental;

public abstract class Vehicle {

    public enum VehicleType {
        CAR, BIKE
    }

    private final String id;
    private final String name;
    private final String vehicleNo;
    private final VehicleType type;
    private final int hourlyCost;
    private final int dailyCost;
    private int kmsDriven;

    protected Vehicle(String id, String name, String vehicleNo, VehicleType type, int hourlyCost, int dailyCost, int kmsDriven) {
        if (hourlyCost <= 0 || dailyCost <= 0 || kmsDriven < 0) {
            throw new IllegalArgumentException("Costs must be positive and kms non-negative");
        }
        this.id = id;
        this.name = name;
        this.vehicleNo = vehicleNo;
        this.type = type;
        this.hourlyCost = hourlyCost;
        this.dailyCost = dailyCost;
        this.kmsDriven = kmsDriven;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public VehicleType getType() {
        return type;
    }

    public int getHourlyCost() {
        return hourlyCost;
    }

    public int getDailyCost() {
        return dailyCost;
    }

    public synchronized int getKmsDriven() {
        return kmsDriven;
    }

    public synchronized void addKms(int kms) {
        if (kms < 0) {
            throw new IllegalArgumentException("Kms driven cannot be negative");
        }
        this.kmsDriven += kms;
    }

    @Override
    public String toString() {
        return id + ":" + name + "(" + vehicleNo + ")";
    }
}
