package com.twu.biblioteca.ui.menus;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.ui.*;
import com.twu.biblioteca.ui.menus.books.BrowseBooks;
import com.twu.biblioteca.ui.menus.users.ViewUserDetails;

public class MainMenu implements MenuItem {

    private final Library library;

    public MainMenu(Library library) {
        this.library = library;
    }

    public String output() {
        return "1.) Browse Books\n" +
               "2.) View membership details\n" +
               "3.) Exit";
    }

    public InputHandler requestInput() {
        return new InputHandler() {
            public String promptUser() {
                return "Please select an option:";
            }

            public MenuItem handleInput(String input) {
                int menuItem = Integer.parseInt(input);
                if (menuItem == 1) {
                    return new BrowseBooks(library);
                } else if (menuItem == 2) {
                    return new ViewUserDetails(library);
                } else if (menuItem == 3) {
                    return null;
                } else {
                    return new InvalidInputMenu(library);
                }
            }
        };
    }
}
