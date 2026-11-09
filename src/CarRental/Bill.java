package CarRental;

import java.util.concurrent.atomic.AtomicInteger;

public class Bill {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    private final String billId;
    private final String reservationId;
    private final long amount;
    private boolean paid;

    public Bill(String reservationId, long amount) {
        this.billId = "B" + ID_GENERATOR.getAndIncrement();
        this.reservationId = reservationId;
        this.amount = amount;
    }

    public synchronized void markPaid() {
        if (paid) {
            throw new IllegalStateException("Bill " + billId + " is already paid");
        }
        this.paid = true;
    }

    public String getBillId() {
        return billId;
    }

    public long getAmount() {
        return amount;
    }

    public synchronized boolean isPaid() {
        return paid;
    }

    @Override
    public synchronized String toString() {
        return billId + "[reservation=" + reservationId + ", amount=" + amount + ", paid=" + paid + "]";
    }
}
