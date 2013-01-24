package com.twu.biblioteca.ui.menus;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.ui.MenuItem;

public class UnderConstructionMenu implements InputHandler {
    private final Library library;

    public UnderConstructionMenu(Library library) {
        this.library = library;
    }

    public String promptUser() {
        return "Press <Any Key> + <Enter> to return to main menu.";
    }

    public MenuItem handleInput(String input) {
        return new MainMenu(library);
    }
}
