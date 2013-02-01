package com.twu.biblioteca.ui.menus;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.ui.MenuItem;
import com.twu.biblioteca.ui.menus.books.BrowseBooks;
import com.twu.biblioteca.ui.menus.users.ViewUserDetails;

public class MainMenu implements MenuItem {

    private final Library library;

    public MainMenu(Library library) {
        this.library = library;
    }

    public String output() {
        return "1.) Browse Books\n" +
               "2.) Browse Movies\n" +
               "3.) View membership details\n" +
               "4.) Exit";
    }

    public InputHandler requestInput() {
        return new InputHandler() {
            public String promptUser() {
                return "Please select an option:";
            }

            public MenuItem handleInput(String input) {
                try {
                    int menuItem = Integer.parseInt(input);
                    if (menuItem == 1) {
                        return new BrowseBooks(library);
                    } else if (menuItem == 2) {
                        return new BrowseMovies(library);
                    } else if (menuItem == 3) {
                        return new ViewUserDetails(library);
                    } else if (menuItem == 4) {
                        return null;
                    } else {
                        return new InvalidInputMenu(library);
                    }
                } catch(NumberFormatException e) {
                    return new InvalidInputMenu(library);
                }

            }
        };
    }
}
