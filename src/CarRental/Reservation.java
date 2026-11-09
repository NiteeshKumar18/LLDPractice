package CarRental;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Reservation {

    public enum Status {
        BOOKED, IN_PROGRESS, COMPLETED, CANCELLED
    }

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    private final String reservationId;
    private final String storeId;
    private final User user;
    private final Vehicle vehicle;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private volatile Status status;
    private Bill bill;

    public Reservation(String storeId, User user, Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime) {
        if (!endTime.isAfter(startTime)) {
            throw new IllegalArgumentException("End time must be after start time");
        }
        this.reservationId = "R" + ID_GENERATOR.getAndIncrement();
        this.storeId = storeId;
        this.user = user;
        this.vehicle = vehicle;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = Status.BOOKED;
    }

    public boolean isActive() {
        return status == Status.BOOKED || status == Status.IN_PROGRESS;
    }

    public boolean overlaps(LocalDateTime start, LocalDateTime end) {
        return isActive() && start.isBefore(endTime) && end.isAfter(startTime);
    }

    public synchronized void pickUp() {
        transition(Status.BOOKED, Status.IN_PROGRESS);
    }

    public synchronized void cancel() {
        transition(Status.BOOKED, Status.CANCELLED);
    }

    public synchronized void complete(Bill bill) {
        transition(Status.IN_PROGRESS, Status.COMPLETED);
        this.bill = bill;
    }

    private void transition(Status expected, Status next) {
        if (status != expected) {
            throw new IllegalStateException("Reservation " + reservationId + " is " + status + ", cannot move to " + next);
        }
        this.status = next;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getStoreId() {
        return storeId;
    }

    public User getUser() {
        return user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Status getStatus() {
        return status;
    }

    public synchronized Bill getBill() {
        return bill;
    }

    @Override
    public String toString() {
        return reservationId + "[" + user + ", " + vehicle + ", " + startTime + " -> " + endTime + ", " + status + "]";
    }
}
