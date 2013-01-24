package com.twu.biblioteca.ui.menus.users;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.ui.MenuItem;
import com.twu.biblioteca.ui.menus.UnderConstructionMenu;

public class ViewUserDetails implements MenuItem {

    private final Library library;

    public ViewUserDetails(Library library) {
        this.library = library;
    }

    public String output() {
        return "Please talk to a Librarian. Thank you.";
    }

    public InputHandler requestInput() {
        return new UnderConstructionMenu(library);
    }
}
