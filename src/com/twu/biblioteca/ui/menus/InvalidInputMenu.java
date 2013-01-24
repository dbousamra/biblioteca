package com.twu.biblioteca.ui.menus;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.ui.MenuItem;

public class InvalidInputMenu implements MenuItem {

    private final Library library;

    public InvalidInputMenu(Library library) {
        this.library = library;
    }

    @Override
    public String output() {
        return "Please Select a valid option!";
    }

    @Override
    public InputHandler requestInput() {
        return new UnderConstructionMenu(library);
    }


}
