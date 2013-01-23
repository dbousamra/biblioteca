package com.twu.biblioteca.ui.menus;

import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.ui.MenuItem;

public class BrowseBooks implements MenuItem {

    @Override
    public String output() {
        return "BROWSING BOOKS\n";
    }

    @Override
    public InputHandler requestInput() {
        return new UnderConstructionMenu();
    }
}
