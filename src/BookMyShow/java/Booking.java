package BookMyShow.java;

import java.util.List;

public class Booking {
    private final int bookingId;
    private List<Seat> listOfSeats;

    private Show show;

    private Payment payment;

    public Booking(int id) {
        this.bookingId = id;
    }


    public void bookSeats(Show show, List<Seat> seats) {
        Seat[][] seatsArray = show.getScreen().getSeatsArray();
        Payment payment1 = new Payment("1234", "gpay", seats.size() * 200);


        this.show = show;
        this.listOfSeats = seats;
        this.payment = payment1;

        for (Seat seat : seats) {
            seatsArray[seat.getRowNo()][seat.getSeatNo()] = seat;
        }
        show.updateBookedSeats(seats);
        System.out.println("Booked the requested seats");

    }
}
