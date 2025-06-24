package CabBooking;

import java.util.Date;

public class Booking {

    private String bookingId;
    private Date time;
    private Location pickupLocation;
    private Location dropOffLocation;
    private int costOfRide;
    private Cab cab;
    private User user;
    private boolean paymentDone;
    private BookingStatus bookingStatus;

    public Booking(String id, Location pickupLocation, Location dropOffLocation, User user, Cab cab) {
        this.bookingId = id;
        this.time = new Date();
        this.pickupLocation = pickupLocation;
        this.dropOffLocation = dropOffLocation;
        this.user = user;
        this.cab = cab;
        this.paymentDone = false;
        this.bookingStatus = BookingStatus.CONFIRMED;
        this.costOfRide = 100;
    }

    // --- Getters ---

    public String getBookingId() {
        return bookingId;
    }

    public Date getTime() {
        return time;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public Location getDropOffLocation() {
        return dropOffLocation;
    }

    public int getCostOfRide() {
        return costOfRide;
    }

    public Cab getCab() {
        return cab;
    }

    public User getUser() {
        return user;
    }

    public boolean isPaymentDone() { // Standard getter for boolean
        return paymentDone;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    // --- Setters ---
    // Note: You might choose not to have setters for all fields
    // if you want some fields to be immutable after creation (e.g., bookingId, time).
    // For this example, I'm providing setters for all non-final fields.

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setPickupLocation(Location pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public void setDropOffLocation(Location dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public void setCostOfRide(int costOfRide) {
        this.costOfRide = costOfRide;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPaymentDone(boolean paymentDone) {
        this.paymentDone = paymentDone;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

}
