package com.twu.biblioteca.ui.menus.books;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.ui.*;

public class BookNotFoundMenu implements MenuItem {
    private final Library library;
    private final String isbn;

    public BookNotFoundMenu(String isbn, Library library) {
        this.isbn = isbn;
        this.library = library;
    }

    public String output() {
        return "Sorry, the ISBN: " + isbn + " did not correspond to a book in our library.\n" +
               "Please make sure you entered a valid ISBN.";
    }

    public InputHandler requestInput() {
        return new InputHandler() {
            public String promptUser() {
                return "Press <Any Key> + <Enter> to return to main menu.";
            }

            public MenuItem handleInput(String input) {
                return new ReserveBookMenu(library);
            }
        };
    }
}
