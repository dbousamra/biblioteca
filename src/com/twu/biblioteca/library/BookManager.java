package com.twu.biblioteca.library;

import com.twu.biblioteca.items.BookNotFoundException;
import com.twu.biblioteca.items.Book;

import java.util.*;

public class BookManager extends ManagerHelper<String, Book> {

    private Set<Book> reserved = new HashSet<Book>();
    /*
    Helper method for books.
    */
    public void addBook(Book item) {
        this.addItem(item.getISBN(), item);
    }

    public boolean reserveBook(String isbn) throws BookNotFoundException {
        Book book = getItem(isbn);
        if (book != null) {
            if (isBookReserved(book.getISBN())) {
                return false;
            } else {
                reserved.add(book);
                return true;
            }
        } else {
            throw new BookNotFoundException(isbn);
        }
    }

    public boolean isBookReserved(String isbn) {
        return reserved.contains(getItem(isbn));
    }
}