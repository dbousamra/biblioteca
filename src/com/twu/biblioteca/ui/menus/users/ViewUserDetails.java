package com.twu.biblioteca.ui.menus.users;

import com.google.common.base.Optional;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.ui.MenuItem;
import com.twu.biblioteca.ui.menus.UnderConstructionMenu;
import com.twu.biblioteca.users.User;

public class ViewUserDetails implements MenuItem {

    private final Library library;

    public ViewUserDetails(Library library) {
        this.library = library;
    }

    public String output() {
        Optional<User> user = library.getUserManager().getCurrentlyLoggedInUser();
        if (user.isPresent()) {
            return user.get().toString();
        } else {
            return "Please talk to a Librarian. Thank you.";
        }
    }

    public InputHandler requestInput() {
        return new UnderConstructionMenu(library);
    }
}
