package CarRental;

public class Bill {
    private final Reservation reservation;
    private final String billId;

    private final double totalBillAmount;

    private final boolean isBillPaid;

    public Bill(Reservation reservation) {
        this.reservation = reservation;
        this.billId = "1234";
        this.totalBillAmount = computeBillAmount();
        this.isBillPaid = true;
    }

    private int computeBillAmount() {
        // Logic to compute the bill amount based on reservation details
        // For simplicity, returning a fixed amount here
        return 100;
    }
}
