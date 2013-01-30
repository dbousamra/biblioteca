package com.twu.biblioteca.items;

public class BookNotFoundException extends Exception {
    public BookNotFoundException(String isbn) {
        super("Book with ISBN: " + isbn + " not found in library.");
    }
}