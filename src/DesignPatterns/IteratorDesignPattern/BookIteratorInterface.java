package DesignPatterns.IteratorDesignPattern;

import java.util.List;

public class BookIteratorInterface implements IteratorInterface {


    private List<Book> booksList;

    private int index = 0;

    public BookIteratorInterface(List<Book> books) {
        this.booksList = books;
    }

    @Override
    public boolean hasNext() {
        return index < this.booksList.size();
    }

    @Override
    public Object next() {

        if (!booksList.isEmpty() && index < this.booksList.size()) {
            return booksList.get(index++);
        }
        return null;
    }
}
