package com.twu.biblioteca.ui.menus.users;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.ui.MenuItem;
import com.twu.biblioteca.ui.menus.UnderConstructionMenu;

public class UserNotLoggedInMenu implements MenuItem {

    private final Library library;

    public UserNotLoggedInMenu(Library library) {
        this.library = library;
    }

    @Override
    public String output() {
        return "You are not logged in. Please return to the main menu and log in.";
    }

    @Override
    public InputHandler requestInput() {
        return new UnderConstructionMenu(library);
    }


}
