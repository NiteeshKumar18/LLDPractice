package LibraryManagement;

public class BookCopy {
    private final String id;
    private boolean issued;
    private final Book book;

    public BookCopy(Book book, String id) {
        this.id = id;
        this.book = book;
    }

    public String getId() {
        return id;
    }

    public boolean isIssued() { // Standard getter for boolean fields
        return issued;
    }

    public Book getBook() {
        return book;
    }

    // --- Setters ---
    // Only for non-final fields

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

}
