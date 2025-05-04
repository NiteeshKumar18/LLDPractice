package CarRental;

import java.util.Date;

public class Reservation {

    private final String reservationId;
    private final String StoreId;
    private Vehicle vehicle;
    private User user;

    private Location pickupLocation;
    private Date startDate;

    private Location dropLocation;
    private Date endDate;

    private int freeKms;

    private boolean billPaid;
    private double totalBill;

    private status reservationStatus;

    public enum status {
        BOOKED, IN_PROGRESS, COMPLETED, CANCELLED
    }

    public Reservation(String reservationId, String storeId, Vehicle vehicle, User user, Location pickupLocation, Date startDate, Location dropLocation, Date endDate) {
        this.reservationId = reservationId;
        StoreId = storeId;
        this.vehicle = vehicle;
        this.user = user;
        this.pickupLocation = pickupLocation;
        this.startDate = startDate;
        this.dropLocation = dropLocation;
        this.endDate = endDate;
    }

    public void setBillPaidAndAMount(int amount, boolean paid){
        this.billPaid=true;
        this.totalBill=amount;
    }
}
