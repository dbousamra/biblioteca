package com.twu.biblioteca.ui.menus.reservations;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.ui.MenuItem;

public class BookNotFoundMenu implements MenuItem {
    private final Library library;
    private final String isbn;

    public BookNotFoundMenu(String isbn, Library library) {
        this.isbn = isbn;
        this.library = library;
    }

    @Override
    public String output() {
        return "Sorry, that book was not found. Please make sure you entered a valid ISBN.";
    }

    @Override
    public InputHandler requestInput() {
        return new InputHandler() {
            @Override
            public String promptUser() {
                return "Please press enter to try again.";
            }

            @Override
            public MenuItem handleInput(String input) {
                return new ReserveBookMenu(library);
            }
        };
    }
}
