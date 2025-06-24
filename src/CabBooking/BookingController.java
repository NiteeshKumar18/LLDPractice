package CabBooking;

import java.util.HashMap;
import java.util.Map;

public class BookingController {
    private Map<String, Booking> bookingMap;

    public BookingController() {
        bookingMap = new HashMap<>();
    }

    public void addBooking(Booking booking) {
        bookingMap.put(booking.getBookingId(), booking);
    }

    public void updateBookingStatus(String bookingId, BookingStatus bookingStatus) {
        bookingMap.get(bookingId).setBookingStatus(bookingStatus);
    }
}
