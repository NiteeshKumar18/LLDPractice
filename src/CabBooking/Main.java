package CabBooking;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Initialize controllers
        BookingController bookingController = new BookingController();
        CabController cabController = new CabController();
        UserController userController = new UserController();

        // Initialize the cab booking service
        CabBookingService cabBookingService = new CabBookingService(userController, bookingController, cabController);

        // Add cab and user
        cabController.addCab();
        User user = new User("123", "abc@gmail.com", 12345, new ArrayList<>(), new Location(8907, 3979));
        userController.addUser(user);

        // Use the service to get cabs and book
        var cabList = cabBookingService.getCabListForUser(user.getUserId());
        System.out.println(cabList);
        cabBookingService.bookCab(cabList.get(0), new Location(1546, 6665), user.getUserId());
    }
}
