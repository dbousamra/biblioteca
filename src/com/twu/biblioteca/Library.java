package com.twu.biblioteca;

import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.library.BookManager;
import com.twu.biblioteca.users.UserManager;

public final class Library {
    private final BookManager registrationManager;
    private final UserManager userManager;

    public Library() {
        this.registrationManager = new BookManager();
        this.userManager = new UserManager();
        this.registrationManager.addBook(new Book("9780684801520", "The Great Gatsby"));
        this.registrationManager.addBook(new Book("9780201310054", "Effective Java"));
        this.registrationManager.addBook(new Book("9780694014361", "The Hobbit"));
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public BookManager getRegistrationManager() {
        return registrationManager;
    }
}
