package com.twu.biblioteca.ui.menus;

import com.google.common.base.Joiner;
import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.ui.MenuItem;

public class BrowseBooks implements MenuItem {

    private Library library = Library.getInstance();

    @Override
    public String output() {
        return Joiner.on('\n').join(library.getRegistrationManager().getAllBooks());
    }

    @Override
    public InputHandler requestInput() {
        return new UnderConstructionMenu();
    }
}
