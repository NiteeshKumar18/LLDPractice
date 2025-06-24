package CabBooking;

import java.util.List;

public class User {

    private String userId;
    private String userEmail;
    private int contactNo;
    private List<String> bookingIds;
    private Location location;

    public User(String userId, String userEmail, int contactNo, List<String> bookingIds,Location location) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.contactNo = contactNo;
        this.bookingIds = bookingIds;
        this.location = location;
    }


    // --- Getters ---

    public String getUserId() {
        return userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public int getContactNo() {
        return contactNo;
    }

    public List<String> getBookingIds() {
        return bookingIds;
    }

    // --- Setters ---

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public void setBookingIds(List<String> bookingIds) {
        this.bookingIds = bookingIds;
    }

    public void addBookingId(String bookingId) {
        this.bookingIds.add(bookingId);
    }

    public Location getLocation() {
        return location;
    }

}
