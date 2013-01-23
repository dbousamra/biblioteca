package com.twu.biblioteca;


public final class Library {
    private static final Library instance = new Library();
    private final ReservationManager registrationManager;
    private final UserManager userManager;

    private Library() {
        this.registrationManager = new ReservationManager();
        this.userManager = new UserManager();
        this.registrationManager.addReservable(new Book("9780684801520", "The Great Gatsby"));
        this.registrationManager.addReservable(new Book("9780201310054", "Effective Java"));
        this.registrationManager.addReservable(new Book("9780694014361", "The Hobbit"));
    }

    public static Library getInstance() {
        return instance;
    }

    public UserManager getUm() {
        return userManager;
    }

    public ReservationManager getRegistrationManager() {
        return registrationManager;
    }
}
