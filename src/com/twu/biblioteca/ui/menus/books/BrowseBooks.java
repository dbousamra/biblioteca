package com.twu.biblioteca.ui.menus.books;

import com.google.common.base.Joiner;
import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.ui.MenuItem;
import com.twu.biblioteca.ui.menus.MainMenu;

import java.util.Collection;

public class BrowseBooks implements MenuItem {

    protected final Library library;

    public BrowseBooks(Library library) {
        this.library = library;
    }

    @Override
    public String output() {
        Collection<Book> books = library.getRegistrationManager().getAllItems();
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
                    return new ReserveBookMenu(library);
                } else if (menuItem == 2) {
                    return new MainMenu(library);
                } else {
                    return new BrowseBooks(library);
                }
            }
        };
    }
}
