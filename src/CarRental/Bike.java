package CarRental;

public class Bike extends Vehicle {
    public Bike(String id, String name, String vehicleNo, int hourlyCost, int dailyCost, int kmsDriven) {
        super(id, name, vehicleNo, VehicleType.BIKE, hourlyCost, dailyCost, kmsDriven);
    }
}

