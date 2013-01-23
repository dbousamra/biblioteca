package com.twu.biblioteca.ui.menus;

import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.ui.MenuItem;

public class ReserveBookMenu extends BrowseBooks {

    @Override
    public InputHandler requestInput() {
        return new InputHandler() {
            @Override
            public String promptUser() {
                return "Please enter the ISBN of the book you would like to reserve.";
            }

            @Override
            public MenuItem handleInput(String input) {
                return new MainMenu();
            }
        };
    }
}
