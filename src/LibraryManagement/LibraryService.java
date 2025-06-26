package LibraryManagement;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LibraryService {

    private LibraryStore libraryStore;

    public LibraryService(LibraryStore libraryStore) {
        this.libraryStore = libraryStore;
    }


    public void addUser() {
        User user = new User(String.valueOf(ThreadLocalRandom.current().nextInt()), "Niteesh");
        libraryStore.users.put(user.getId(), user);
    }

    public void addBook(int copies) {
        Book book = new Book(String.valueOf(ThreadLocalRandom.current().nextInt()), "GOT", "Niteesh", "Action");
        List<BookCopy> bookCopyList = new ArrayList<BookCopy>();
        for (int i = 0; i < copies; i++) {
            BookCopy bookCopy = new BookCopy(book, String.valueOf(ThreadLocalRandom.current().nextInt()));
            bookCopyList.add(bookCopy);
        }
        libraryStore.booksMap.put(book.getId(), book);
        libraryStore.bookIdToCopiesMap.put(book, bookCopyList);

    }

    public boolean getBook(String name, String userId) {
        User user = libraryStore.users.get(userId);
        if (user == null) {
            return false;
        }
        Book book = libraryStore.booksMap.values().stream().filter(b -> b.getName().equals(name)).findFirst().orElse(null);
        if (book == null) {
            return false;
        }

        List<BookCopy> bookCopyList = libraryStore.bookIdToCopiesMap.get(book.getId());
        if (bookCopyList == null || bookCopyList.isEmpty()) {
            return false;
        }
        BookCopy bookCopy = bookCopyList.stream().filter(bookCopy1 -> !bookCopy1.isIssued()).findFirst().orElse(null);
        if (bookCopy == null) {
            return false;
        }
        bookCopy.setIssued(true);
        System.out.println("Found book copy of GOT" + bookCopy.getId());
        Booking booking = new Booking(String.valueOf(ThreadLocalRandom.current().nextInt()), userId, bookCopy.getId(), new Date(), new Date());
        libraryStore.bookingMap.put(book.getId(), booking);
        return true;
    }
}
