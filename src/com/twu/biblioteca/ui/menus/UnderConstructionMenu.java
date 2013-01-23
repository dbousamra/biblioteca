package com.twu.biblioteca.ui.menus;

import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.ui.MenuItem;

public class UnderConstructionMenu implements InputHandler {
    @Override
    public String promptUser() {
        return "Please select an option";
    }

    @Override
    public MenuItem handleInput(String input) {
        return new MainMenu();
    }
}
