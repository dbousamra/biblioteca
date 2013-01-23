package com.twu.biblioteca.ui.menus;

import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.ui.MenuItem;

public class ViewUserDetails implements MenuItem {
    @Override
    public String output() {
        return "Please talk to a Librarian. Thank you.";
    }

    @Override
    public InputHandler requestInput() {
        return new UnderConstructionMenu();
    }
}