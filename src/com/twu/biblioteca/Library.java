package com.twu.biblioteca;
import com.twu.biblioteca.ui.*;
import com.twu.biblioteca.ui.menus.MainMenu;

public class Library {
    private static final Library instance = new Library();
    private final ReservationManager rm;
    private final UserManager um;
    private final UIRunner uir;


    public Library() {
        this.rm = new ReservationManager();
        this.um = new UserManager();
        this.uir = new UIRunner(new MainMenu());
    }

    public static Library getInstance() {
        return instance;
    }

    public void run() {
        uir.run();

    }

}

