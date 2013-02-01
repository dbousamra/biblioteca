package com.twu.biblioteca.ui.menus.users;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.ui.MenuItem;
import com.twu.biblioteca.ui.menus.UnderConstructionMenu;
import com.twu.biblioteca.users.User;

public class LoggedInSuccessfullyMenu implements MenuItem {
    private final Library library;
    private final User user;

    public LoggedInSuccessfullyMenu(User user, Library library) {
        this.user = user;
        this.library = library;
    }

    @Override
    public String output() {
        return "Thank you for logging in " + user.getName();
    }

    @Override
    public InputHandler requestInput() {
        return new UnderConstructionMenu(library);
    }
}
