package DesignPatterns.IteratorDesignPattern;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("1", "book1");
        Book book2 = new Book("2", "book2");
        Book book3 = new Book("3", "book3");

        Library library = new Library(List.of(book1, book2, book3));
        IteratorInterface iteratorInterface = library.createIterator();

        while (iteratorInterface.hasNext()) {
            System.out.println(iteratorInterface.next());
        }

    }
}
