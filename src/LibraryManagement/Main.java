package LibraryManagement;

public class Main {
    public static void main(String[] args) {
      LibraryStore libraryStore = new LibraryStore();
      LibraryService libraryService = new LibraryService(libraryStore);

    }
}
