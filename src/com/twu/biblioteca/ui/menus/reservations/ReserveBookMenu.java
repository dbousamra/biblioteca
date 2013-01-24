package com.twu.biblioteca.ui.menus.reservations;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.items.BookNotFoundException;
import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.ui.MenuItem;
import com.twu.biblioteca.ui.menus.BrowseBooks;

public class ReserveBookMenu extends BrowseBooks {


    public ReserveBookMenu(Library library) {
        super(library);
    }

    @Override
    public InputHandler requestInput() {
        return new InputHandler() {
            @Override
            public String promptUser() {
                return "Please enter the ISBN of the book you would like to reserve";
            }

            @Override
            public MenuItem handleInput(String isbn) {
                try {
                    boolean reserved = library.getRegistrationManager().reserveBook(isbn);
                    if (reserved) {
                        return new BookReservedSuccessfully(library);
                    } else {
                        return new BookReservedUnsuccessfully(library);
                    }
                } catch (BookNotFoundException e) {
                    return new BookNotFoundMenu(isbn, library);
                }
            }
        };
    }
}
