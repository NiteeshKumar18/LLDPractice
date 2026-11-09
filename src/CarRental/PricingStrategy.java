package CarRental;

import java.time.LocalDateTime;

public interface PricingStrategy {
    long calculate(Vehicle vehicle, LocalDateTime start, LocalDateTime end);
}

