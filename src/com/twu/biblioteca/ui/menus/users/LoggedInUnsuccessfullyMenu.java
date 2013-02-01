package com.twu.biblioteca.ui.menus.users;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.ui.MenuItem;
import com.twu.biblioteca.ui.menus.UnderConstructionMenu;

public class LoggedInUnsuccessfullyMenu implements MenuItem {
    private final Library library;

    public LoggedInUnsuccessfullyMenu(Library library) {
        this.library = library;
    }

    @Override
    public String output() {
        return "Sorry. The username and password you supplied did not match with a valid user in our database. Pleas try again";
    }

    @Override
    public InputHandler requestInput() {
        return new UnderConstructionMenu(library);
    }
}
