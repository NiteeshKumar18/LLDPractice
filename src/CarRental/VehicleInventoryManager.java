package CarRental;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VehicleInventoryManager {

    private final Map<String, Vehicle> vehicles = new ConcurrentHashMap<>();
    private final Map<String, List<Reservation>> reservationsByVehicle = new ConcurrentHashMap<>();

    public VehicleInventoryManager(List<Vehicle> vehicles) {
        vehicles.forEach(this::addVehicle);
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicles.putIfAbsent(vehicle.getId(), vehicle) != null) {
            throw new IllegalArgumentException("Vehicle " + vehicle.getId() + " already exists");
        }
        reservationsByVehicle.put(vehicle.getId(), new ArrayList<>());
    }

    public void removeVehicle(String vehicleId) {
        Vehicle vehicle = getVehicle(vehicleId);
        synchronized (vehicle) {
            if (reservationsByVehicle.get(vehicleId).stream().anyMatch(Reservation::isActive)) {
                throw new IllegalStateException("Vehicle " + vehicleId + " has active reservations");
            }
            vehicles.remove(vehicleId);
            reservationsByVehicle.remove(vehicleId);
        }
    }

    public Vehicle getVehicle(String vehicleId) {
        Vehicle vehicle = vehicles.get(vehicleId);
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle " + vehicleId + " not found");
        }
        return vehicle;
    }

    public List<Vehicle> searchAvailable(Vehicle.VehicleType type, LocalDateTime start, LocalDateTime end) {
        return vehicles.values().stream()
                .filter(vehicle -> vehicle.getType() == type)
                .filter(vehicle -> isAvailable(vehicle, start, end))
                .sorted(Comparator.comparing(Vehicle::getId))
                .toList();
    }

    public void addReservation(Reservation reservation) {
        Vehicle vehicle = reservation.getVehicle();
        synchronized (vehicle) {
            if (!isAvailable(vehicle, reservation.getStartTime(), reservation.getEndTime())) {
                throw new IllegalStateException("Vehicle " + vehicle.getId() + " is not available from "
                        + reservation.getStartTime() + " to " + reservation.getEndTime());
            }
            reservationsByVehicle.get(vehicle.getId()).add(reservation);
        }
    }

    private boolean isAvailable(Vehicle vehicle, LocalDateTime start, LocalDateTime end) {
        synchronized (vehicle) {
            List<Reservation> reservations = reservationsByVehicle.get(vehicle.getId());
            return reservations != null && reservations.stream().noneMatch(r -> r.overlaps(start, end));
        }
    }
}
