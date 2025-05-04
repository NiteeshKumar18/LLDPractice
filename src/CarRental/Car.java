package CarRental;

public class Car extends Vehicle{
    public Car(String id, String name, int kms, String vehicleNo, int hourlyCost, int dailyCost, VEHICLE_TYPE type) {
        super(id, name, kms, vehicleNo, hourlyCost, dailyCost, type);
    }
}
