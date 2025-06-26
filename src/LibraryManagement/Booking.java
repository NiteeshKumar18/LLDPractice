package LibraryManagement;

import java.util.Date;

public class Booking {

    private final String bookindId;
    private final String userId;
    private final String bookCopyId;
    private final Date bookingDate;

    private Date returnDate;

    public Booking(String bookindId, String userId, String bookCopyId, Date bookingDate, Date returnDate) {
        this.bookindId = bookindId;
        this.userId = userId;
        this.bookCopyId = bookCopyId;
        this.bookingDate = bookingDate;
    }


    public String getBookindId() { // Using original field name 'bookindId'
        return bookindId;
    }

    public String getUserId() {
        return userId;
    }

    public String getBookCopyId() {
        return bookCopyId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    // --- Setters ---
    // Only for non-final fields

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

}
