package com.twu.biblioteca;

import com.twu.biblioteca.ui.UIRunner;
import com.twu.biblioteca.ui.menus.MainMenu;

public class  BibliotecaApp {

    public static void main(String[] args) {
        UIRunner runner = new UIRunner(new MainMenu(new Library()));
        runner.run();
    }
}
