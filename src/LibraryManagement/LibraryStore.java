package LibraryManagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryStore {
    public Map<String, User> users;
    public Map<String, Book> booksMap;
    public Map<String,Booking> bookingMap;
    public Map<Book, List<BookCopy>> bookIdToCopiesMap;

    public LibraryStore() {
        users = new HashMap<>();
        booksMap = new HashMap<>();
        bookingMap = new HashMap<>();
    }
}
