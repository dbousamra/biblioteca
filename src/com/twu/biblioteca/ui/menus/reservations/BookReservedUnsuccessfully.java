package com.twu.biblioteca.ui.menus.reservations;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.ui.MenuItem;
import com.twu.biblioteca.ui.menus.UnderConstructionMenu;

public class BookReservedUnsuccessfully implements MenuItem {

    private final Library library;

    public BookReservedUnsuccessfully(Library library) {
        this.library = library;
    }

    @Override
    public String output() {
        return "Sorry we don't have that book yet.";
    }

    @Override
    public InputHandler requestInput() {
        return new UnderConstructionMenu(library);
    }
}
