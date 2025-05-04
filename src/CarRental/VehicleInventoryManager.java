package CarRental;

import java.util.List;

public class VehicleInventoryManager {

    private List<Vehicle> vehicles;

    public VehicleInventoryManager(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
