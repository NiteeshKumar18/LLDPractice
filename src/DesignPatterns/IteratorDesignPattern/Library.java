package DesignPatterns.IteratorDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Library implements Aggregate {

    private List<Book> booksList = new ArrayList<>();


    public Library(List<Book> books) {
        this.booksList = books;
    }


    @Override
    public IteratorInterface createIterator() {
        return new BookIteratorInterface(this.booksList);
    }
}
