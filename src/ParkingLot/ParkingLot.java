package ParkingLot;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {
    private static ParkingLot instance;
    private String name;
    private List<ParkingFloor> floors;
    private Map<String, Ticket> activeTickets;
    private PricingStrategy pricingStrategy;

    private ParkingLot(String name) {
        this.name = name;
        this.floors = new ArrayList<>();
        this.activeTickets = new HashMap<>();
        this.pricingStrategy = new HourlyPricingStrategy();
    }

    // Singleton pattern
    public static synchronized ParkingLot getInstance(String name) {
        if (instance == null) {
            instance = new ParkingLot(name);
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public void setPricingStrategy(PricingStrategy strategy) {
        this.pricingStrategy = strategy;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.findAvailableSpot(vehicle);
            if (spot != null && spot.parkVehicle(vehicle)) {
                String ticketId = UUID.randomUUID().toString();
                Ticket ticket = new Ticket(ticketId, vehicle, spot);
                activeTickets.put(ticketId, ticket);
                System.out.println("Vehicle " + vehicle.getLicensePlate() + " parked at Floor " 
                    + floor.getFloorNumber() + ", Spot " + spot.getSpotId());
                return ticket;
            }
        }
        System.out.println("No available spot for vehicle " + vehicle.getLicensePlate());
        return null;
    }

    public double unparkVehicle(String ticketId) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket == null) {
            System.out.println("Invalid ticket ID");
            return 0.0;
        }

        ticket.setExitTime(LocalDateTime.now());
        double amount = pricingStrategy.calculatePrice(ticket);
        ticket.setAmount(amount);

        // Free the spot
        ticket.getSpot().removeVehicle();
        activeTickets.remove(ticketId);

        System.out.println("Vehicle " + ticket.getVehicle().getLicensePlate() + " unparked. Amount: $" + amount);
        return amount;
    }

    public void displayAvailability() {
        System.out.println("\n=== Parking Lot: " + name + " ===");
        for (ParkingFloor floor : floors) {
            System.out.println("Floor " + floor.getFloorNumber() + ": " 
                + floor.getAvailableSpots() + " spots available");
        }
    }

    public String getName() {
        return name;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }
}

