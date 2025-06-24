package CabBooking;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BookingController bookingController = new BookingController();
        CabController cabController = new CabController();
        UserController userController = new UserController(bookingController, cabController);
        cabController.addCab();
        User user = new User("123", "abc@gmail.com", 12345, new ArrayList<>(), new Location(8907, 3979));
        userController.addUser(user);
        var cabList = userController.getCabListForUser(user.getUserId());
        System.out.println(cabList);
        userController.bookCab(cabList.get(0), new Location(1546, 6665), user.getUserId());
    }
}
