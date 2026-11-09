package CarRental;

public class Car extends Vehicle {
    public Car(String id, String name, String vehicleNo, int hourlyCost, int dailyCost, int kmsDriven) {
        super(id, name, vehicleNo, VehicleType.CAR, hourlyCost, dailyCost, kmsDriven);
    }
}
