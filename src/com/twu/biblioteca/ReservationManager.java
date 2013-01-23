package com.twu.biblioteca;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import java.util.Collections;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;

public class ReservationManager {

    private Map<Book, Boolean> bookCollection;

    public ReservationManager() {
        this.bookCollection = new LinkedHashMap<Book, Boolean>();
    }

    public void addReservable(Book item) {
        this.bookCollection.put(item, false);
    }

    public int getBookCount() {
        return bookCollection.size();
    }

    public boolean isBookReserved(Book book) {
        return bookCollection.get(book);
    }

    public boolean reserveBook(Book book) {
        if (bookCollection.get(book) == false) {
            bookCollection.put(book, true);
            return true;
        } else {
            return false;
        }
    }

//    public Book getBookByISBN(String isbn) {
//        Iterables.find(new Predicate<Book>(isbn) {
//            @Override
//            public boolean apply(Book book) {
//                return book.getISBN().equals(isbn);
//            }
//        }, this.getAllBooks());
//    }

    public Set<Book> getAllBooks() {
        return Collections.unmodifiableSet(this.bookCollection.keySet());
    }
}