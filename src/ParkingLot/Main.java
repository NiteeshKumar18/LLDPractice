package ParkingLot;

public class Main {
    public static void main(String[] args) {
        // Create parking lot
        ParkingLot parkingLot = ParkingLot.getInstance("City Center Parking");

        // Create floors
        ParkingFloor floor1 = new ParkingFloor(1);
        ParkingFloor floor2 = new ParkingFloor(2);

        // Add spots to floor 1
        floor1.addSpot(new ParkingSpot("F1-M1", SpotType.MOTORCYCLE, 1));
        floor1.addSpot(new ParkingSpot("F1-M2", SpotType.MOTORCYCLE, 1));
        floor1.addSpot(new ParkingSpot("F1-C1", SpotType.COMPACT, 1));
        floor1.addSpot(new ParkingSpot("F1-C2", SpotType.COMPACT, 1));
        floor1.addSpot(new ParkingSpot("F1-L1", SpotType.LARGE, 1));

        // Add spots to floor 2
        floor2.addSpot(new ParkingSpot("F2-C1", SpotType.COMPACT, 2));
        floor2.addSpot(new ParkingSpot("F2-C2", SpotType.COMPACT, 2));
        floor2.addSpot(new ParkingSpot("F2-L1", SpotType.LARGE, 2));
        floor2.addSpot(new ParkingSpot("F2-H1", SpotType.HANDICAPPED, 2));

        // Add floors to parking lot
        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        // Display initial availability
        parkingLot.displayAvailability();

        // Create vehicles
        Vehicle motorcycle = new Vehicle("M-1234", VehicleType.MOTORCYCLE);
        Vehicle car1 = new Vehicle("C-5678", VehicleType.CAR);
        Vehicle car2 = new Vehicle("C-9012", VehicleType.CAR);
        Vehicle van = new Vehicle("V-3456", VehicleType.VAN);
        Vehicle truck = new Vehicle("T-7890", VehicleType.TRUCK);

        // Park vehicles
        System.out.println("\n=== Parking Vehicles ===");
        Ticket ticket1 = parkingLot.parkVehicle(motorcycle);
        Ticket ticket2 = parkingLot.parkVehicle(car1);
        Ticket ticket3 = parkingLot.parkVehicle(car2);
        Ticket ticket4 = parkingLot.parkVehicle(van);
        Ticket ticket5 = parkingLot.parkVehicle(truck);

        // Display availability after parking
        parkingLot.displayAvailability();

        // Simulate some time passing and unpark vehicles
        System.out.println("\n=== Unparking Vehicles ===");
        if (ticket1 != null) {
            parkingLot.unparkVehicle(ticket1.getTicketId());
        }
        if (ticket2 != null) {
            parkingLot.unparkVehicle(ticket2.getTicketId());
        }

        // Display final availability
        parkingLot.displayAvailability();
    }
}

