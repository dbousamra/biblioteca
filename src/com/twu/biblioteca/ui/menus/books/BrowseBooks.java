package com.twu.biblioteca.ui.menus.books;

import com.google.common.base.Joiner;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.ui.InputHandler;
import com.twu.biblioteca.ui.MenuItem;
import com.twu.biblioteca.ui.menus.InvalidInputMenu;
import com.twu.biblioteca.ui.menus.MainMenu;
import com.twu.biblioteca.ui.menus.users.UserNotLoggedInMenu;

import java.util.Collection;

public class BrowseBooks implements MenuItem {

    protected final Library library;

    public BrowseBooks(Library library) {
        this.library = library;
    }

    @Override
    public String output() {
        Collection<Book> books = library.getBookManager().getAllItems();
        if (!books.isEmpty()) {
            return books.size() + " books found\n" + Joiner.on('\n').join(books);
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
                try {
                    int menuItem = Integer.parseInt(input);
                    if (menuItem == 1) {
                        if (library.getUserManager().getCurrentlyLoggedInUser().isPresent()) {
                            return new ReserveBookMenu(library);
                        }
                        else {
                            return new UserNotLoggedInMenu(library);
                        }
                    } else if (menuItem == 2) {
                        return new MainMenu(library);
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
