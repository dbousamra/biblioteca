package com.twu.biblioteca;

public class  BibliotecaApp {

    private static final BibliotecaApp instance = new BibliotecaApp();
    private final ReservationManager rm;
    private final UserManager um;

    private BibliotecaApp() {
        this.rm = new ReservationManager();
        this.um = new UserManager();
    }

    public static BibliotecaApp getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        BibliotecaApp ba = getInstance();
        ba.rm.addReservable(new Book("9780140177398", "Of Mice and Men"));
        System.out.println(ba.rm.getAllBooks());
    }
}
