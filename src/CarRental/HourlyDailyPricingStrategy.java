package CarRental;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyDailyPricingStrategy implements PricingStrategy {

    @Override
    public long calculate(Vehicle vehicle, LocalDateTime start, LocalDateTime end) {
        long minutes = Duration.between(start, end).toMinutes();
        long hours = (minutes + 59) / 60;
        long days = hours / 24;
        long remainingHours = hours % 24;
        long remainingCost = Math.min(remainingHours * vehicle.getHourlyCost(), vehicle.getDailyCost());
        return days * vehicle.getDailyCost() + remainingCost;
    }
}

