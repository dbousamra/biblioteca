package com.twu.biblioteca.library;

import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.BookNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class BookManager extends Reserver<String, Book> {

    private final Set<Book> reserved = new HashSet<Book>();

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

    public boolean isBookReserved(String isbn) throws BookNotFoundException {
        if(getItem(isbn) != null) {
            return reserved.contains(getItem(isbn));
        } else {
            throw new BookNotFoundException(isbn);
        }

    }
}