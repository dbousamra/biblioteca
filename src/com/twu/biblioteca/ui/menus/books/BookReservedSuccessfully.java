package com.twu.biblioteca.ui.menus.books;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.ui.MenuItem;
import com.twu.biblioteca.ui.menus.UnderConstructionMenu;

public class BookReservedSuccessfully implements MenuItem {

    private final Library library;

    public BookReservedSuccessfully(Library library) {
        this.library = library;
    }

    @Override
    public String output() {
        return "Thank You! Enjoy the book.";
    }

    @Override
    public InputHandler requestInput() {
        return new UnderConstructionMenu(library);
    }
}
