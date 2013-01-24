package com.twu.biblioteca.items;

public class BookNotFoundException extends Exception {

    public BookNotFoundException() {
        super();
    }

    public BookNotFoundException(String isbn) {
        super("Book with ISBN: " + isbn + " not found in library.");
    }

    public BookNotFoundException(String isbn, Throwable cause) {
        super("Book with ISBN: " + isbn + " not found in library.", cause);
    }

    public BookNotFoundException(Throwable cause) {
        super(cause);
    }
}