package com.twu.biblioteca.ui;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.ui.menus.MainMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UIRunner {

    private final MenuItem startingMenu;

    public UIRunner(MenuItem startingMenu) {
        this.startingMenu = startingMenu;
    }

    private void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public void run() {
        MenuItem currentMenu = this.startingMenu;
        while(true) {
            System.out.println("\n");
            System.out.println(currentMenu.output());
            System.out.println("=======================================");
            System.out.println(currentMenu.requestInput().promptUser());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                String input = br.readLine();
                currentMenu = currentMenu.requestInput().handleInput(input);
            } catch (IOException e) {
                throw new RuntimeException("Unable to read input from user");
            }
            clearConsole();
        }
    }
}
