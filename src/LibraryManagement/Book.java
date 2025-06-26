package LibraryManagement;

public class Book {
    private final String id;
    private final String name;
    private final String author;
    private final String category;

    public Book(String id, String name, String author, String category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

}
