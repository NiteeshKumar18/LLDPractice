package BookMyShow.java;

public class Seat {
    private int seatNo;
    private int rowNo;

    private SeatType seatType;


    public Seat(int seatNo, int rowNo, SeatType type) {
        this.seatNo = seatNo;
        this.rowNo = rowNo;
        this.seatType = type;
    }

    private boolean isBoooked;

    public boolean getIsBooked() {
        return this.isBoooked;
    }

    public void setIsBooked(boolean booked) {
        this.isBoooked = booked;
    }

    public int getSeatNo() {
        return this.seatNo;
    }

    public int getRowNo() {
        return this.getRowNo();
    }

    public enum SeatType {
        NORMAL, RECLAINER
    }
}
