package com.twu.biblioteca.ui.menus;

import com.google.common.base.Joiner;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.ui.MenuItem;

import java.util.Set;

public class BrowseBooks implements MenuItem {

    protected Library library = Library.getInstance();

    @Override
    public String output() {
        Set<Book> books = library.getRegistrationManager().getAllBooks();
        if (!books.isEmpty()) {
            return Joiner.on('\n').join(books);
        } else {
            return "Their are currently no books in the library.";
        }
    }

    @Override
    public InputHandler requestInput() {
        return new InputHandler() {
            @Override
            public String promptUser() {
                return "1.) Reserve a book\n" +
                       "2.) Return to main menu.";
            }

            @Override
            public MenuItem handleInput(String input) {
                int menuItem = Integer.parseInt(input);
                if (menuItem == 1) {
                    return new ReserveBookMenu();
                } else if (menuItem == 2) {
                    return new MainMenu();
                } else {
                    return new MainMenu();
                }
            }
        };
    }
}
