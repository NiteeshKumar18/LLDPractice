package ParkingLot;

public class HourlyPricingStrategy implements PricingStrategy {
    private static final double MOTORCYCLE_RATE = 10.0;
    private static final double CAR_RATE = 20.0;
    private static final double VAN_RATE = 30.0;
    private static final double TRUCK_RATE = 40.0;

    @Override
    public double calculatePrice(Ticket ticket) {
        long hours = ticket.getParkedDurationInHours();
        if (hours == 0) {
            hours = 1; // Minimum 1 hour charge
        }

        double rate = 0.0;
        switch (ticket.getVehicle().getType()) {
            case MOTORCYCLE:
                rate = MOTORCYCLE_RATE;
                break;
            case CAR:
                rate = CAR_RATE;
                break;
            case VAN:
                rate = VAN_RATE;
                break;
            case TRUCK:
                rate = TRUCK_RATE;
                break;
        }

        return hours * rate;
    }
}

