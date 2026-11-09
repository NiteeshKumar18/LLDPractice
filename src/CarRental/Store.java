package CarRental;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Store {

    private final String storeId;
    private final Location location;
    private final VehicleInventoryManager vehicleInventoryManager;
    private final PricingStrategy pricingStrategy;
    private final Map<String, Reservation> reservations = new ConcurrentHashMap<>();

    public Store(String storeId, Location location, List<Vehicle> vehicles, PricingStrategy pricingStrategy) {
        this.storeId = storeId;
        this.location = location;
        this.vehicleInventoryManager = new VehicleInventoryManager(vehicles);
        this.pricingStrategy = pricingStrategy;
    }

    public List<Vehicle> searchVehicles(Vehicle.VehicleType type, LocalDateTime start, LocalDateTime end) {
        return vehicleInventoryManager.searchAvailable(type, start, end);
    }

    public Reservation reserve(User user, String vehicleId, LocalDateTime start, LocalDateTime end) {
        Vehicle vehicle = vehicleInventoryManager.getVehicle(vehicleId);
        Reservation reservation = new Reservation(storeId, user, vehicle, start, end);
        vehicleInventoryManager.addReservation(reservation);
        reservations.put(reservation.getReservationId(), reservation);
        return reservation;
    }

    public void pickUp(String reservationId) {
        getReservation(reservationId).pickUp();
    }

    public Bill returnVehicle(String reservationId, LocalDateTime returnTime, int kmsDriven) {
        Reservation reservation = getReservation(reservationId);
        LocalDateTime billUntil = returnTime.isAfter(reservation.getEndTime()) ? returnTime : reservation.getEndTime();
        long amount = pricingStrategy.calculate(reservation.getVehicle(), reservation.getStartTime(), billUntil);
        Bill bill = new Bill(reservationId, amount);
        reservation.complete(bill);
        reservation.getVehicle().addKms(kmsDriven);
        return bill;
    }

    public void cancel(String reservationId) {
        getReservation(reservationId).cancel();
    }

    public Reservation getReservation(String reservationId) {
        Reservation reservation = reservations.get(reservationId);
        if (reservation == null) {
            throw new IllegalArgumentException("Reservation " + reservationId + " not found");
        }
        return reservation;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleInventoryManager.addVehicle(vehicle);
    }

    public void removeVehicle(String vehicleId) {
        vehicleInventoryManager.removeVehicle(vehicleId);
    }

    public String getStoreId() {
        return storeId;
    }

    public Location getLocation() {
        return location;
    }
}
