package CabBooking;

import java.util.List;

public class CabBookingService {
    private UserController userController;
    private BookingController bookingController;
    private CabController cabController;

    public CabBookingService(UserController userController, BookingController bookingController, CabController cabController) {
        this.userController = userController;
        this.bookingController = bookingController;
        this.cabController = cabController;
    }

    public List<Cab> getCabListForUser(String userId) {
        User user = userController.getUser(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found: " + userId);
        }
        return cabController.getAllCabs(user.getLocation(), 30);
    }

    public Booking bookCab(Cab cab, Location dropLocation, String userId) {
        User user = userController.getUser(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found: " + userId);
        }
        
        Booking booking = new Booking("1234", user.getLocation(), dropLocation, user, cab);
        cabController.updateCabAvailability(cab.getCabId(), false);
        user.addBookingId(booking.getBookingId());
        bookingController.addBooking(booking);
        return booking;
    }
}

