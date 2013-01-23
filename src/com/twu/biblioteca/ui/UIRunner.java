package com.twu.biblioteca.ui;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class UIRunner {

    private final MenuItem start;

    public UIRunner(MenuItem start) {
        this.start = start;
    }

    public void run() {
        Console console = System.console();
        MenuItem currentMenu = this.start;
        while(true) {
            System.out.println(currentMenu.output());
            System.out.println(currentMenu.requestInput().promptUser());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                String input = br.readLine();
                currentMenu = currentMenu.requestInput().handleInput(input);
            } catch (IOException e) {
               throw new RuntimeException("Unable to read input from user");
            }
        }
    }
}
