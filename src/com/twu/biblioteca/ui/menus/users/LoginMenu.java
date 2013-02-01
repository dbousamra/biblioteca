package com.twu.biblioteca.ui.menus.users;

import com.google.common.base.Optional;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.ui.MenuItem;
import com.twu.biblioteca.users.User;

public class LoginMenu implements MenuItem {
    private final Library library;

    public LoginMenu(Library library) {
        this.library = library;
    }

    @Override
    public String output() { return "Please enter your credentials"; }

    @Override
    public InputHandler requestInput() {
        return new InputHandler() {
            @Override
            public String promptUser() { return "Please enter your username"; }

            @Override
            public MenuItem handleInput(final String username) {
                return new MenuItem() {
                    @Override
                    public String output() { return "Please enter your credentials."; }

                    @Override
                    public InputHandler requestInput() {
                        return new InputHandler() {
                            @Override
                            public String promptUser() { return "Please enter your password."; }
                            @Override
                            public MenuItem handleInput(String password) {
                                Optional<User> user = library.getUserManager().authenticateUser(username, password);
                                if (user.isPresent()) {
                                    return new LoggedInSuccessfullyMenu(user.get(), library);
                                } else {
                                    return new LoggedInUnsuccessfullyMenu(library);
                                }
                            }
                        };
                    }
                };
            }
        };
    }
}
