package com.twu.biblioteca.ui.menus;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.ui.MenuItem;

public class InvalidInputMenu implements MenuItem {

    private final Library library;
    private final MenuItem previous;

    public InvalidInputMenu(Library library, MenuItem previous) {
        this.library = library;
        this.previous = previous;
    }

    @Override
    public String output() {
        return "Please Select a valid option!!";
    }

    @Override
    public InputHandler requestInput() {
        return new InputHandler() {
            @Override
            public String promptUser() {
                return "";
            }

            @Override
            public MenuItem handleInput(String input) {
                return previous;
            }
        };
    }
}
