package CabBooking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserController {
    private BookingController bookingController;
    private Map<String, User> userMap;
    private CabController cabController;

    public void addUser(User user) {
        userMap.put(user.getUserId(), user);
    }

    public UserController(BookingController bookingController, CabController cabController) {
        this.bookingController = bookingController;
        this.userMap = new HashMap<>();
        this.cabController = cabController;
    }

    public List<Cab> getCabListForUser(String userId) {
        return cabController.getAllCabs(userMap.get(userId).getLocation(), 30);
    }

    public Booking bookCab(Cab cab, Location dropLocation, String userId) {
        User user = userMap.get(userId);
        Booking booking = new Booking("1234", user.getLocation(), dropLocation, user, cab);
        cabController.updateCabAvailability(cab.getCabId(), false);
        user.addBookingId(booking.getBookingId());
        bookingController.addBooking(booking);
        return booking;
    }


}
